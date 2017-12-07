package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.mock.interceptor.MockFor
import groovy.util.GroovyTestCase

class MsbuildRunnerTest extends GroovyTestCase {
    void testRunBuild() {
        def mock = new MockFor(ExecHelper)
        mock.demand.runCommand{ 'hello' }
        mock.use {
            def msbuildRunner = new MsbuildRunner('','','','')
            assert msbuildRunner.runMsbuild('') == 'hello'
        }
    }
}
