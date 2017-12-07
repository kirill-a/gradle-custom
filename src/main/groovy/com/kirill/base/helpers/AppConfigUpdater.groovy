package com.kirill.base.helpers

import com.kirill.base.XmlUpdater

class AppConfigUpdater {
    def xmlUpdater

    def loadFile(String pathToFile) {
        this.xmlUpdater = new XmlUpdater(pathToFile)
    }

    def set(String key, String value) {
        xmlUpdater.func { it.appSettings.add.find { it.@key == key }.@value = value }
    }

    void save() {
        xmlUpdater.save()
    }
}
