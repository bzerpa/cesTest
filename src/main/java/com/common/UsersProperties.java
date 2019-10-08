package com.common;

import java.util.Properties;

public class UsersProperties extends Properties {

    // Constants in users properties file

    private final String PHYSICIANS_NAME = "physicianName";
    private final String PATIENT_NAME = "patientName";
    private final String PARTNER_NAME = "partnerName";
    private final String PHYSICIANS_EMAIL = "physicianEmail";
    private final String PATIENT_EMAIL = "patientEmail";
    private final String MOBILE_USER = "mobileUser";
    private final String MOBILE_USER_NAME = "mobileUserName";
    private final String PATIENT_MOBILE_EMAIL = "patientMobileEmail";
    private final String PARTNER_EMAIL = "partnerEmail";
    private final String PHYSICIANS_PASS = "physicianPass";
    private final String MOBILE_PASS = "mobilePassword";
    private final String PATIENT_PASS = "patientPass";
    private final String ADMIN_NAME = "adminName";
    private final String ADMIN_EMAIL = "adminEmail";
    private final String ADMIN_PASS = "adminPass";
    private final String SUPER_ADMIN_EMAIL = "superAdminEmail";
    private final String SUPER_ADMIN_PASS = "superAdminPass";
    private final String WRONG_EMAIL = "wrongEmail";
    private final String WRONG_PASS = "wrongPass";
    private final String USER_UNDERAGE = "userUnderage";
    private final String USER_NOT_UNDERAGE = "userNotUnderage";
    private final String MEDICAL_RECORD_NUMBER = "medicalRecordNumber";
    private final String MOBILE_PRIMUS_USER = "mobilePrimusUser";
    private final String MOBILE_PRIMUS_PASS = "mobilePrimusPassword";
    private final String SUPER_ADMIN_NAME = "superAdminName";

    public UsersProperties() {

    }

    // public void parseConfigFile() {
    // try {
    // String fileName = "";
    // List<String> supportedEnvironments = Arrays.asList("la-freeze","la-prod","la-qa");
    // String environment = this.getProperty(ConfigDictionary.ENVIRONMENT_PROPERTY);
    //
    // if (supportedEnvironments.contains(environment)) {
    // fileName = environment + "-config.properties";
    // } else {
    // fileName = "local_TestSettings.properties";
    // }
    // // Open the File and parse all the config values from project dir
    // String fileSep = System.getProperty("file.separator");
    // String abspath = "resources" + fileSep + "la";
    // FileInputStream in = new FileInputStream(abspath + fileSep + fileName);
    // this.load(in);
    // in.close();
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // }
    // }

    public String getConfigValue(String key) {
        String property = this.getProperty(key);
        if (property == null) {
            System.out.println("Sorry, unable to find " + key);
        }
        return property;
    }


    public String getPhysicianEmail() {
        return getConfigValue(PHYSICIANS_EMAIL);
    }

    public String getPatientMobileEmail() {
        return getConfigValue(PATIENT_MOBILE_EMAIL);
    }

    public String getPhysicianName() {
        return getConfigValue(PHYSICIANS_NAME);
    }

    public String getPhysicianPass() {
        return getConfigValue(PHYSICIANS_PASS);
    }

    public String getAdminEmail() {
        return getConfigValue(ADMIN_EMAIL);
    }

    public String getAdminPass() {
        return getConfigValue(ADMIN_PASS);
    }

    public String getPatientPass() {
        return getConfigValue(PATIENT_PASS);
    }

    public String getSuperAdminEmail() {
        return getConfigValue(SUPER_ADMIN_EMAIL);
    }

    public String getSuperAdminPass() {
        return getConfigValue(SUPER_ADMIN_PASS);
    }

    public String getSuperAdminName() {
        return getConfigValue(SUPER_ADMIN_NAME);
    }

    public String getWrongEmail() {
        return getConfigValue(WRONG_EMAIL);
    }

    public String getWrongPass() {
        return getConfigValue(WRONG_PASS);
    }

    public String getAdminName() {
        return getConfigValue(ADMIN_NAME);
    }

    public String getUserUnderage() {
        return getConfigValue(USER_UNDERAGE);
    }

    public String getUserNotUnderage() {
        return getConfigValue(USER_NOT_UNDERAGE);
    }

    public String getMedicalRecordNumber() {
        return getConfigValue(MEDICAL_RECORD_NUMBER);
    }

    public String getPatientEmail() {
        return getConfigValue(PATIENT_EMAIL);
    }

    public String getPatientName() {
        return getConfigValue(PATIENT_NAME);
    }

    public String getPartnerEmail() {
        return getConfigValue(PARTNER_EMAIL);
    }

    public String getPartnerName() {
        return getConfigValue(PARTNER_NAME);
    }

    public String getMobileUser() {
        return getConfigValue(MOBILE_USER);
    }

    public String getMobilePass() {
        return getConfigValue(MOBILE_PASS);
    }

    public String getUrineKetonesUser() {
        return getConfigValue(MOBILE_PRIMUS_USER);
    }

    public String getUrineKetonesPass() {
        return getConfigValue(MOBILE_PRIMUS_PASS);
    }

    public String getMobileUserName() {
        return getConfigValue(MOBILE_USER_NAME);
    }

}
