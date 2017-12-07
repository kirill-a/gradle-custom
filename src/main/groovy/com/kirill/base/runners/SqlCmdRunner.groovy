package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class SqlCmdRunner {
    String srvAlias

    SqlCmdRunner(String serverAlias) {
        this.srvAlias = serverAlias
    }

    boolean runSqlFile(String fileToExec, String dbName) {
        ArrayList<String> commandList = []
        commandList.add('sqlcmd')
        commandList.add('-b')
        commandList.add('-E')
        commandList.add('-S')
        commandList.add(srvAlias)
        commandList.add('-d')
        commandList.add(dbName)
        commandList.add('-i')
        commandList.add(fileToExec)
        def execHelper = new ExecHelper()
        return execHelper.runCommand(commandList)
    }

    boolean runSqlQuery(String scriptToExec, String dbName) {
        ArrayList<String> commandList = []
        commandList.add('sqlcmd')
        commandList.add('-b')
        commandList.add('-E')
        commandList.add('-S')
        commandList.add(srvAlias)
        commandList.add('-d')
        commandList.add(dbName)
        commandList.add('-Q')
        commandList.add(scriptToExec)
        def execHelper = new ExecHelper()
        return execHelper.runCommand(commandList)
    }
}
