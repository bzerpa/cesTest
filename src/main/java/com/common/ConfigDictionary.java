package com.common;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 * 
 */

public class ConfigDictionary {

    public final String FILE_SEPARATOR_PROPERTY = "file.separator";
    public final String DEVICE_PROPERTY = "device";
    public final String USER_PROPERTY = "users";
    public final String API_PROPERTY = "api";
    private DeviceProperties deviceProperties;
    private UsersProperties usersProperties;
    private ApiProperties apiProperties;

    // Singleton Instance
    private static ConfigDictionary instance = null;

    public static synchronized ConfigDictionary getInstance() {
        if (instance == null) {
            instance = new ConfigDictionary();
        }
        return instance;
    }

    private ConfigDictionary() {
        try {
            // Initialize Properties
            deviceProperties = new DeviceProperties();
            usersProperties = new UsersProperties();
            apiProperties = new ApiProperties();

            String device = System.getProperty(DEVICE_PROPERTY);
            String user = System.getProperty(USER_PROPERTY);
            String api = System.getProperty(API_PROPERTY);

            // Load Properties from files
            String fileName = device + "-config.properties";
            String fileUsersName = user + "-config.properties";
            String fileApiName = api + "-config.properties";

            // Open the File and parse all the config values from project dir
            String fileSeparator = System.getProperty(FILE_SEPARATOR_PROPERTY);
            String abspath = "resources" + fileSeparator + "devices";
            String absUserspath = "resources" + fileSeparator + "users";
            String absApipath = "resources" + fileSeparator + "api";
            FileInputStream in;

            in = new FileInputStream(abspath + fileSeparator + fileName);
            deviceProperties.load(in);
            in.close();
            in = new FileInputStream(absUserspath + fileSeparator + fileUsersName);
            usersProperties.load(in);
            in.close();
            in = new FileInputStream(absApipath + fileSeparator + fileApiName);
            apiProperties.load(in);
            in.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * Returns the environment properties
     */
    public DeviceProperties getDeviceProperties() {
        return deviceProperties;
    }

    /**
     * Returns the environment properties
     */
    public UsersProperties getUsersProperties() {
        return usersProperties;
    }

    /**
     * Returns the environment properties
     */
    public ApiProperties getApiProperties() {
        return apiProperties;
    }

}
