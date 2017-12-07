package com.kirill.base

import com.kirill.base.helpers.FileHelper

class TabSpaceConverter {

    def convertTabsForSingleFile = { String filepath ->
        File file = new File(filepath)
        String content = file.text
        if (content.find('\t')) {
            content = content.replaceAll('\\t', '    ')
            file.delete()
            file.write(content, 'UTF-8')
            println('Changed tabs to spaces for file: ' + filepath)
        }

    }

    void fixTabsForFilesInFolderRecursively(String folder, String filePattern) {
        FileHelper.listFilesRecursively(folder, filePattern, convertTabsForSingleFile)
    }
}
