package com.automation.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtilities {

    public static String GetGlobalConfig(String key) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/com/automation/framework/config/GlobalConfig.properties");
        Properties prop = new Properties();
        prop.load(fileInputStream);
        return String.valueOf(prop.getProperty(key));
    }
}
