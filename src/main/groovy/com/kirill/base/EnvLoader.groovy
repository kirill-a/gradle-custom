package com.kirill.base

class EnvLoader {

    static String getEnv(String property, String pathToFile = 'config/env_vars.properties') {
        File propertiesFile = new File(pathToFile)
        Properties properties = new Properties()
        properties.load(propertiesFile.newDataInputStream())
        properties.getProperty(property)
    }

    static void setEnv(String propertyName, String newValue, String pathToFile = 'config/env_vars.properties') {
        File propertiesFile = new File(pathToFile)
        Properties properties = new Properties()
        properties.load(propertiesFile.newDataInputStream())
        properties.setProperty(propertyName, newValue)
        OutputStream out = new FileOutputStream(propertiesFile)
        properties.store(out, null)
    }
}
