package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.mock.interceptor.MockFor
import groovy.util.GroovyTestCase

class GitRunnerTest extends GroovyTestCase {
    void testMerge() {
        def mock = new MockFor(ExecHelper)
        mock.demand.runCommand{ 'hello' }
        mock.use {
            GitRunner git = new GitRunner()
            assert git.merge('') == 'hello'
        }
    }
}
