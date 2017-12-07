package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class GitRunner {

    def merge(String branch) {
        List<String> commandList = []
        commandList.add("git")
        commandList.add("merge")
        commandList.add("--no-ff")
        commandList.add(branch)
        def execHelper = new ExecHelper()
        return execHelper.runCommand(commandList)
    }
}
