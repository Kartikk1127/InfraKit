package com.infrakit


fun main(args: Array<String>) {
    if (args.isNotEmpty() && args[0].equals("init", ignoreCase = true)) {
        println("Project created")
    } else {
        println("Usage: infrakit init")
    }
}