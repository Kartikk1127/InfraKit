package com.infrakit.utils

import java.io.File

object ParserUtil {

    fun doInit(args: Array<String>) {
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

        val packagePath = packageName.replace('.', File.separatorChar)
        val templateDir = File("templates/spring-boot-base")
        val outputDir = File(projectName)

        if (outputDir.exists()) {
            println("Error: Directory '$projectName' already exists.")
            return
        }

        TemplateGenerator.copyAndReplace(
            templateDir,
            outputDir,
            mapOf(
                "appName" to projectName,
                "packageName" to packageName,
                "packagePath" to packagePath
            )
        )

        println("🏗️  Project '$projectName' created successfully.")
        println("cd $projectName")
    }
}