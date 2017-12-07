package com.kirill.base

import groovy.util.GroovyTestCase

class ExecHelperTest extends GroovyTestCase {

    void testStreamPrinter() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream()
        def oldStr = System.out
        System.setOut(new PrintStream(out))
        def pb = new ProcessBuilder(['cmd.exe', '/C', 'dir'])
        def proc = pb.start()
        def strPrn = new StreamPrinter(proc.getInputStream(), out)
        strPrn.run()
        println out.toString()
        assertTrue(out.toString().contains("build.gradle"))
        System.setOut(oldStr)
    }
}
