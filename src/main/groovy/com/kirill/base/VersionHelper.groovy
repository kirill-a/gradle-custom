package com.kirill.base

import groovy.transform.TypeChecked

@TypeChecked
class VersionHelper {
    String[] versionList
    String version

    def createVersionList(String version) {
        this.version = version
        this.versionList = version.tokenize('.')
    }

    String major() {
        versionList[0]
    }

    String minor() {
        versionList[1]
    }

    String release() {
        versionList[2]
    }

    String revision() {
        versionList[3]
    }

    static String getNewVersion(String currentVersion) {
        String revision = System.getenv('REVISION') ?: '0'
        String newVersion = currentVersion.replaceAll(/\d+$/, revision)
        return newVersion
    }
}
