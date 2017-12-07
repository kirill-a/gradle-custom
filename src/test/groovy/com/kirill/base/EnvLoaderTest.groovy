package com.kirill.base

class EnvLoaderTest extends GroovyTestCase {
    void testGetEnv() {
        assert EnvLoader.getEnv('PROJECT', 'config/env_vars.properties') == 'proj'
    }
}
