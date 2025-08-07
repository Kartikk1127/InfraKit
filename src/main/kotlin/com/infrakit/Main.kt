package com.infrakit

import com.infrakit.utils.ParserUtil


fun main(args: Array<String>) {
    if (args.isEmpty() || args[0] != "init") {
        println("Usage: infrakit init --name=<project> --package=<package>")
        return
    }

    ParserUtil.doInit(args)
}