package com.learning.ultils

import java.io.File

class FileUtils {
    companion object {
        fun write(fileName:String, content:String) {
            File(fileName).printWriter().use { out ->
                out.println(content)
            }
        }
        fun readAndTrim(fileName: String): String
                = File(fileName).readText(Charsets.UTF_8).trim()
    }

}