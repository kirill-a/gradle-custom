package com.kirill.base

import java.nio.charset.Charset
import java.nio.charset.CharsetEncoder

class NonAsciiChecker {

    static boolean isAsciiOnly(File file) {
        CharsetEncoder asciiEncoder = Charset.forName('US-ASCII').newEncoder()
        CharsetToolkit toolkit = new CharsetToolkit(file)
        Charset guessedCharset = toolkit.charset
        boolean result = asciiEncoder.canEncode(removeBomFromFile(file, guessedCharset.toString()).toString())
        if (!result) {
            println('The following files contain incorrect encoding, please convert it to UTF-8: ' + file.path)
        }
        return result
    }

    static List<String> removeBomFromFile(File file, String codePage) {
        List<String> fileContent = file.getText(codePage).readLines()
        CharsetToolkit kit = new CharsetToolkit(file)
        if (kit.hasUTF8Bom()) {
            String firstRow = fileContent[0].substring(1)
            fileContent[0] = firstRow
        }
        return fileContent
    }
}
