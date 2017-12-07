package com.kirill.base

import groovy.xml.XmlUtil

class XmlMerger {

    def mergeXml(String path, String fileMask, String root, String node, String resultPath) {
        File results = new File(resultPath)
        if (results.exists()) { results.delete() }
        results.setText("<${root}></${root}>")
        String newLine = System.getProperty('line.separator')
        String fileContent = NonAsciiChecker.removeBomFromFile(results, 'UTF-8').join(newLine)
        def resultsNode = new XmlSlurper(false, false).parseText(fileContent)

        List<String> listFilesToMerge = new FileNameFinder().getFileNames(path, fileMask)
        listFilesToMerge.each { filePath ->
            File file = new File(filePath)
            String content = NonAsciiChecker.removeBomFromFile(file, 'UTF-8').join(newLine)
            def rootNode = new XmlSlurper().parseText(content)
            resultsNode.appendNode(rootNode."${node}")
        }
        String xmlResult = XmlUtil.serialize( resultsNode )
        results.withWriter { outWriter ->
            outWriter.append(xmlResult)
        }
    }
}
