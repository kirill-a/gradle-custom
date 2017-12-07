package com.kirill.base

import groovy.xml.XmlUtil

class XmlUpdater {
    Node rootNode
    File file

    XmlUpdater(String pathToFile) {
        this.file = new File(pathToFile)
        String newLine = System.getProperty('line.separator')
        String fileContent = NonAsciiChecker.removeBomFromFile(file, 'UTF-8').join(newLine)
        this.rootNode = new XmlParser(false, false).parseText(fileContent)
    }

    def func(Closure cl) {
        try {
            return cl(rootNode)
        }
        catch (MissingFieldException e) {
            println('XML has not been updated! Msg: ' + e.message)
            return rootNode
        }
    }

    def save() {
        file.withWriter { outWriter ->
            XmlUtil.serialize(rootNode, outWriter)
        }
    }
}
