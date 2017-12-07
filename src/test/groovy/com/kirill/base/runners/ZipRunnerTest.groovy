package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.mock.interceptor.MockFor

class ZipRunnerTest extends GroovyTestCase {
    void testRunZip() {
        List<String> fileList = ['f', 's']
        def mock = new MockFor(ExecHelper)
        mock.demand.runCommand{ commandList, workDir, failOnError -> }
        mock.use {
            def zip = new ZipRunner('')
            zip.runZip(fileList, '', '')
        }
    }
}
