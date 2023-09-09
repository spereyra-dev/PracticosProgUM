package main

import (
	"encoding/json"
	"log"
	"net/http"
	"os"

	"github.com/gorilla/mux"
)

const zero = 1

type Task struct {
	ID      string `json:"id"`
	Title   string `json:"title"`
	Content string `json:"content"`
}

var tasks = []Task{
	{ID: "1", Title: "Tarea 1", Content: "Contenido de la Tarea 1"},
	{ID: "2", Title: "Tarea 2", Content: "Contenido de la Tarea 2"},
	{ID: "3", Title: "Tarea 3", Content: "Contenido de la Tarea 3"},
}

var logger *log.Logger // Declarar el logger como una variable global

func init() {
	// Inicializar el logger en la función init() del paquete principal
	logger = log.New(os.Stdout, "INFO: ", log.Ldate|log.Ltime)
}

func main() {
	defer handlePanic()
	logfile, err := os.Create("app.log")
	log.SetOutput(logfile)
	if err != nil {
		log.Fatal(err)
	}
	log.Println("Starting the application...")
	router := mux.NewRouter()

	// Simulamos un error que causa un panic
	// divideByZero := func() {
	// 	zero := zero - 1
	// 	fmt.Println(10 / zero)
	// }
	// divideByZero()

	// Rutas de la API
	router.HandleFunc("/tasks", GetTasks).Methods("GET")
	router.HandleFunc("/tasks/{id}", GetSingleTask).Methods("GET")
	router.HandleFunc("/tasks", CreateTask).Methods("POST")
	router.HandleFunc("/tasks/{id}", UpdateTask).Methods("PUT")
	router.HandleFunc("/tasks/{id}", DeleteTask).Methods("DELETE")

	log.Fatal(http.ListenAndServe(":8080", router))
	defer logfile.Close()
}

func GetTasks(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(tasks)
	logger.Print("GetTasks() called successfully")
}

func GetSingleTask(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	for _, item := range tasks {
		if item.ID == params["id"] {
			w.Header().Set("Content-Type", "application/json")
			json.NewEncoder(w).Encode(item)
			logger.Print("GetSingleTask() called successfully")
			return
		}
	}
	http.Error(w, "Task not found", http.StatusNotFound)
	logger.Panic("GetSingleTask() called with invalid id")
}

func CreateTask(w http.ResponseWriter, r *http.Request) {
	var task Task
	_ = json.NewDecoder(r.Body).Decode(&task)
	tasks = append(tasks, task)
	w.Header().Set("Content-Type", "application/json")
	json.NewEncoder(w).Encode(task)
	logger.Print("CreateTask() called successfully")
}

func UpdateTask(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	for index, item := range tasks {
		if item.ID == params["id"] {
			var updatedTask Task
			_ = json.NewDecoder(r.Body).Decode(&updatedTask)
			tasks[index] = updatedTask
			w.Header().Set("Content-Type", "application/json")
			json.NewEncoder(w).Encode(updatedTask)
			logger.Print("UpdateTask() called successfully")
			return
		}
	}
	http.Error(w, "Task not found", http.StatusNotFound)
	logger.Panic("UpdateTask() called with invalid id")
}

func DeleteTask(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	for index, item := range tasks {
		if item.ID == params["id"] {
			tasks = append(tasks[:index], tasks[index+1:]...)
			w.WriteHeader(http.StatusNoContent)
			logger.Print("DeleteTask() called successfully")
			return
		}
	}
	http.Error(w, "Task not found", http.StatusNotFound)
	logger.Panic("DeleteTask() called with invalid id")
}

func handlePanic() {
	if r := recover(); r != nil {
		log.Printf("¡Se ha producido un panic: %v!", r)
		// Puedes realizar acciones adicionales aquí, como guardar registros o limpiar recursos.
	}
}
