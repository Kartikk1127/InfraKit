package com.infrakit


fun main(args: Array<String>) {
    if (args.isEmpty() || args[0] != "init") {
        println("Usage: infrakit init --name=<project> --package=<package>")
        return
    }

    var projectName: String? = null
    var packageName: String? = null

    args.drop(1).forEach { arg ->
        when {
            arg.startsWith("--name=") -> projectName = arg.removePrefix("--name=")
            arg.startsWith("--package=") -> packageName = arg.removePrefix("--package=")
        }
    }

    if (projectName.isNullOrBlank() || packageName.isNullOrBlank()) {
        println("Error: both --name and --package are required.")
        println("Usage: infrakit init --name=<project> --package=<package>")
        return
    }

    println("Init called! Project: $projectName  Package: $packageName")
}