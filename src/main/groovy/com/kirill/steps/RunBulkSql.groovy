package com.kirill.steps

import com.kirill.base.runners.SqlCmdRunner
import groovy.transform.TypeChecked

@TypeChecked
class RunBulkSql {

    boolean deploy(String folder, String action, String serverAlias, String dbName) {
        ArrayList<String> scriptsList = []

        scriptsList.addAll(new FileNameFinder().getFileNames(folder + '/' + action, "*.sql"))
        SqlCmdRunner sqlRun = new SqlCmdRunner(serverAlias)
        scriptsList.each { it -> sqlRun.runSqlFile(it, dbName) }
    }
}
