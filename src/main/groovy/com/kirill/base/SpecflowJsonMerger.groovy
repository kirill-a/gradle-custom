package com.kirill.base

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

class SpecflowJsonMerger {

    def mergeJson(String path, String resultPath) {
        File results = new File(resultPath)
        if (results.exists()) { results.delete() }
        String newLine = System.getProperty('line.separator')
        def features = []
        List<String> listFilesToMerge = new FileNameFinder().getFileNames(path, '*.json')
        listFilesToMerge.each { filePath ->
            File file = new File(filePath)
            String content = NonAsciiChecker.removeBomFromFile(file, 'UTF-8').join(newLine)
            def document = new JsonSlurper().parseText(content)
            features.addAll(document.features)
        }
        def jsonResult = JsonOutput.toJson('features':features)
        results.setText('var reportData = ')
        results.append(jsonResult)
    }
}
