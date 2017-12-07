package com.kirill.base

import groovy.transform.TypeChecked

@TypeChecked
class StreamPrinter extends Thread {
    InputStream is
    OutputStream os

    StreamPrinter(InputStream is, OutputStream os) {
        this.is = is
        this.os = os
    }

    void run() {
        def pw = new PrintWriter(os)
        InputStreamReader isr = new InputStreamReader(is)
        BufferedReader br = new BufferedReader(isr)
        String line
        String newLine = System.getProperty('line.separator')
        File log = new File('gradle_log.txt')
        while ((line = br.readLine()) != null) {
            log << line + newLine
            pw.println(line)
            pw.flush()
        }
    }
}
