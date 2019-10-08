package com.common;

public class Utility {

    // API data
    public enum APIData {
        CARE_PLAN_NAME("Api Automated care plan"), CARE_PLAN_DESCRIPTION("Api Automated care plan"), FACILITY_ID(
                "ORG000040"),
        // PATIENT_FIRST_NAME("Api Automated"), PATIENT_LAST_NAME("Patient"), PATIENT_MRN_NO("MRN#19199"),
        // PATIENT_FULL_NAME("Api Automated Patient"),
        // PATIENT_EMAIL("apiautomatedpatient@mailinator.com"), PATIENT_DOB("1998-10-13"), PATIENT_PIN("5555"),
        // INVITOR_USER_ID("US000001"),
        PATIENT_FIRST_NAME("Api Automated"), PATIENT_LAST_NAME("Patient Two");

        private String name;

        private APIData(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum Device {
        IOS("iOS"), ANDROID("Android"), CHROME("Chrome"), FIREFOX("Firefox"), MAC_OS("Mac OS"), EDGE("Edge");

        private String name;

        private Device(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }



}
