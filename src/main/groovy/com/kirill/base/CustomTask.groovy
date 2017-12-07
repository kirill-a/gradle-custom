package com.kirill.base

import groovy.transform.TypeChecked
import org.gradle.api.DefaultTask

@TypeChecked
class CustomTask extends DefaultTask {
    ResourceBundle loadedProps

    CustomTask() {
        String proj = EnvLoader.getEnv('PROJECT')
        String filePath = 'gradle_' + proj.toLowerCase()
        ResourceBundle loadedProps = ResourceBundle.getBundle(filePath)
        this.loadedProps = loadedProps
    }
}
