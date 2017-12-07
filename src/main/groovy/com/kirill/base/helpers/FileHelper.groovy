package com.kirill.base.helpers

import groovy.transform.TypeChecked
import org.apache.commons.io.FileUtils

@TypeChecked
class FileHelper {
    static void copyDirContents (String src, String dst, String includePattern = /.*/) {
        File srcDir = new File(src)
        File dstDir = new File(dst)
        FileUtils.forceMkdir(dstDir)
        for (File srcFile: srcDir.listFiles()) {
            if (srcFile.isDirectory() && includePattern == /.*/) {
                println('Copying directory ' + srcFile.toString() + ' to ' + dst)
                FileUtils.copyDirectoryToDirectory(srcFile, dstDir)
            } else if (srcFile.name =~ includePattern) {
                println('Copying file ' + srcFile.toString() + ' to ' + dst)
                FileUtils.copyFileToDirectory(srcFile, dstDir)
            }
        }
    }

    static void deleteFileList(String src, String includePattern = '*') {
        def srcList = new FileNameFinder().getFileNames(src, includePattern)
        srcList.each { it ->
            println('Deleting file ' + it)
            FileUtils.forceDelete(new File(it))
        }
    }

    static void deleteIfExists(String filename) {
        File file = new File(filename)
        if (file.exists()) {
            FileUtils.forceDelete(file)
            println('File has been deleted: ' + filename)
        }
    }

    static void copyIfExists(String src, String dst) {
        File file = new File(src)
        if (file.exists()) {
            file.isDirectory() ? copyDir(src, dst) : copyFile(src, dst)
        }
    }

    static void moveIfExists(String src, String dst) {
        copyIfExists(src, dst)
        deleteIfExists(src)
    }

    static void copyFile(String src, String dst) {
        FileUtils.copyFile(new File(src), new File(dst))
    }

    static void copyDir(String src, String dst) {
        FileUtils.copyDirectory(new File(src), new File(dst))
    }

    static void mkDir(String path) {
        FileUtils.forceMkdir(new File(path))
    }

    static void mkDirRec(String path) {
        new File(path).mkdirs()
    }

    static void listFilesRecursively(String folder, String filePattern, Closure cl) {
        for (File file : new File(folder).listFiles()) {
            if (file.isFile() && file.name.matches(filePattern)) {
                cl(file.absolutePath)
            } else if (file.isDirectory()) {
                listFilesRecursively(file.absolutePath, filePattern, cl)
            }
        }
    }
}
