# fraud-rules-go-sdk

## Description

> **_NOTE:_** Add your description here

## Usage

### Installation
`go get github.com/melisource/fury_fraud-rules-go-sdk`

### Examples

> **_NOTE:_** Add code snippets

***

We recommend you follow the same [code style](https://github.com/mercadolibre/fury_go-toolkit/blob/master/CODING_GUIDELINES.md) of the Go toolkit project.

This repo represents the init template for a fury application, the idea is to replace all the variables with data of the application and set up all the files and directories with the right values.

If you want to add a custom template for some technology or team, please contact us through our [contribution guide](CONTRIBUTING.md).

## Development

`fury get fraud-rules-go-sdk`

Write your code...

`fury test`

## Contributing

In order to contribute to this library, you must read [this guide](CONTRIBUTING.md) first.

## Changelog

We keep changes to our codebase [here](CHANGELOG.md)

## Library Versioning

Go modules works correctly if people follow [`Semver`](https://semver.org/). Please follow semver as best as possible to simplify the job of other developers when updating projects that depends on your library.

When releasing a v2+ version, consider the requirements of `go.mod` and update your module name accordingly.

## Dependency Management

The proposed method for managing dependencies is `go mod`.

Even though `go mod` allows you to have several modules defined in the same repository we recommend you avoid doing it.

The recommended pattern is to have a single `go.mod / go.sum` in the root folder of the repository, in which all packages dependencies are specified.

### Links

* [Using Go Modules](https://blog.golang.org/using-go-modules).
* [Migrating to Go Modules](https://blog.golang.org/migrating-to-go-modules).
