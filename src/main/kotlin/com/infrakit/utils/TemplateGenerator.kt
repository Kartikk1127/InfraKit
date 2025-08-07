package com.infrakit.utils

import java.io.File

object TemplateGenerator {

    fun copyAndReplace(
        source: File,
        dest: File,
        variables: Map<String, String>,
        relPath: String = ""
    ) {
        val relative = relPath.ifEmpty { "" }
        var destPath = replaceVarsInPath(relative, variables)

        // If it's a file with .ftl, remove .ftl in output
        if (source.isFile && destPath.endsWith(".ftl")) {
            destPath = destPath.removeSuffix(".ftl")
        }
        val actualDest = File(dest, destPath)

        if (source.isDirectory) {
            actualDest.mkdirs()
            source.listFiles()?.forEach { child ->
                val childRelPath = if (relative.isEmpty()) child.name else "$relative/${child.name}"
                copyAndReplace(child, dest, variables, childRelPath)
            }
        } else {
            var content = source.readText()
            variables.forEach { (key, value) ->
                content = content.replace("{{${key}}}", value)
            }
            // Ensure parent directory exists
            actualDest.parentFile.mkdirs()
            actualDest.writeText(content)
        }
    }

    private fun replaceVarsInPath(path: String, variables: Map<String, String>): String {
        var res = path
        variables.forEach { (key, value) ->
            res = res.replace("{{${key}}}", value)
        }
        return res
    }
}