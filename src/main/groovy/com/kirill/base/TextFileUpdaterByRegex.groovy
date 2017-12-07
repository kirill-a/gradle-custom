package com.kirill.base

import groovy.transform.TypeChecked

@TypeChecked
class TextFileUpdaterByRegex {
    File file
    String fileContent

    TextFileUpdaterByRegex(String filePath) {
        this.file = new File(filePath)
        this.fileContent = file.getText('UTF-8')
    }

    String update(String regExp, String newValue) {
        fileContent = fileContent.replaceAll(regExp, newValue)
    }

    void save() {
        file.write(fileContent, 'UTF-8')
    }
}
