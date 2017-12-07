package com.kirill.steps

import com.kirill.base.runners.GitRunner
import groovy.transform.TypeChecked

@TypeChecked
class GitMergeRecursively {

    def merge(List<String> branches) {
        def git = new GitRunner()
        for (branch in branches) {
            git.merge(branch)
        }
    }
}
