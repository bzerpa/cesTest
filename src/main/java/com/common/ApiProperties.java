package com.common;

import java.util.Properties;

public class ApiProperties extends Properties {

    private final String GRANT_TYPE = "grantType";
    private final String LOGIN_URL = "loginUrl";
    private final String LOGIN_MOBILE_URL = "loginMobileUrl";
    private final String LOGIN_ADMIN_URL = "loginAdminUrl";
    private final String CLIENT_ID = "clientId";
    private final String CLIENT_MOBILE_ID = "clientMobileId";
    private final String CLIENT_ADMIN_ID = "clientAdminId";
    private final String HOST = "host";
    private final String ADMIN_HOST = "adminHost";


    public String getConfigValue(String key) {
        String property = this.getProperty(key);
        if (property == null) {
            System.out.println("Sorry, unable to find " + key);
        }
        return property;
    }

    public String getGrantType() {
        return getConfigValue(GRANT_TYPE);
    }

    public String getLoginUrl() {
        return getConfigValue(LOGIN_URL);
    }

    public String getLoginMobileUrl() {
        return getConfigValue(LOGIN_MOBILE_URL);
    }

    public String getLoginAdminUrl() {
        return getConfigValue(LOGIN_ADMIN_URL);
    }

    public String getClientId() {
        return getConfigValue(CLIENT_ID);
    }

    public String getClientMobileId() {
        return getConfigValue(CLIENT_MOBILE_ID);
    }

    public String getClientAdminId() {
        return getConfigValue(CLIENT_ADMIN_ID);
    }

    public String getHost() {
        return getConfigValue(HOST);
    }

    public String getAdminHost() {
        return getConfigValue(ADMIN_HOST);
    }


}
