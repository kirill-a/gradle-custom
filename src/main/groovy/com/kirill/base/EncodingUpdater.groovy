package com.kirill.base

import com.kirill.base.helpers.FileHelper

class EncodingUpdater {

    def makeUTF8forSingleFile = { String filepath ->
        File file = new File(filepath)
        String content = file.text
        file.delete()
        file.write(content, 'UTF-8')
        println('Encoding has been changed for file: ' + filepath)
    }

    void fixEncodingForFilesInFolderRecursively(String folder, String filePattern) {
        FileHelper.listFilesRecursively(folder, filePattern, makeUTF8forSingleFile)
    }

}
