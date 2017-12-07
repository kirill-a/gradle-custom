package com.kirill.base.helpers

class VersionTest extends GroovyTestCase {
    void testGetMajor() throws Exception {
        def version = new Version('3.99.0')
        assert version.major == 3
        assert version.minor == 99
        assert version.micro == 0
        def version1 = new Version('3.99')
        assert version1.major == 3
        assert version1.minor == 99
        assert version1.micro == 0
        try { new Version('3.99.5.4') }
        catch (e) { assert e in IllegalArgumentException }
    }

    void testEquals() throws Exception {
        def version1 = new Version('1.3.44')
        def version2 = new Version(1,3,44)
        assert version1 == version2
    }
}
