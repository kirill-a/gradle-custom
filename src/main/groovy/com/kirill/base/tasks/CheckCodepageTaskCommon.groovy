package com.kirill.base.tasks

import com.kirill.base.CustomTask
import com.kirill.steps.CheckCodepage
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

class CheckCodepageTaskCommon extends CustomTask {
    @TaskAction
    check() {
        CheckCodepage check = new CheckCodepage()
        boolean hasNonAscii = check.checkAllFiles()
        if (hasNonAscii) {
            throw new GradleException("[ERROR] Source files contain non-UTF symbols")
        }
    }
}

