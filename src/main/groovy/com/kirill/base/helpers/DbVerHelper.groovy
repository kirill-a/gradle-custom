package com.kirill.base.helpers

import groovy.transform.TypeChecked

@TypeChecked
class DbVerHelper {
    static List<String> listDbVersions(String dbDir) {
        List<String> list = []
        def srcDir = new File(dbDir)
        for (File srcFile: srcDir.listFiles()) {
            if (srcFile.name =~ /^\d+\.\d+\.\d+/) {
                list << srcFile.name
            }
        }
        return list
    }

    static String getLatestDbVersion(List<String> dbVersions) {
        List<Version> listVersions = []
        dbVersions.each {
            def ver = new Version(it)
            listVersions.add(ver)
        }
        listVersions.sort().reverse().first()
    }
}
