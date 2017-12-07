package com.kirill.steps

import com.kirill.base.NonAsciiChecker

class CheckCodepage {

    boolean checkAllFiles() {
        List<String> targetFiles= new FileNameFinder().getFileNames('.', '**/*.vb **/*.cs **/*.frm **/*.ctl **/*.cls **/*.bas **/*.wix')
        boolean hasNonAscii = false
        targetFiles.each {
            if (!NonAsciiChecker.isAsciiOnly(new File(it))) {
                hasNonAscii = true
            }
        }
        return hasNonAscii
    }
}
