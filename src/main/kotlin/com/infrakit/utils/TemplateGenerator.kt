package com.infrakit.utils

import java.io.File

object TemplateGenerator {

    fun copyAndReplace(
        source: File,
        dest: File,
        variables: Map<String, String>
    ) {
        // Calculate the destination folder/file name with replacement
        val destPath = replaceVarsInPath(dest.path, variables)
        val actualDest = File(destPath)

        if (source.isDirectory) {
            actualDest.mkdirs()
            source.listFiles()?.forEach { child ->
                copyAndReplace(child, File(actualDest, child.name), variables)
            }
        } else {
            // Copy file, replace placeholders in content
            var content = source.readText()
            variables.forEach { (key, value) ->
                content = content.replace("{{${key}}}", value)
            }
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