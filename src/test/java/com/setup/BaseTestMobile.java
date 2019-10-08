package com.setup;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.interfaces.BaseTestInterface;
import com.page.mobile.LoginMobile;
import io.appium.java_client.AppiumDriver;


public class BaseTestMobile implements BaseTestInterface {


    public static AppiumDriver driver;
    protected WebDriverWait wait;
    private String testCaseName;
    private long testStartTime;
    private long testFinishTime;
    private long testDurationTime;
    private String testFailedMsg;

    protected String invalidDate = "Date should be within the last 24 hours.";

    public WebDriver getDriver() {
        return driver;
    }

    protected long getTestStartTime() {
        return testStartTime;
    }

    protected void setTestStartTime(long testStartTime) {
        this.testStartTime = testStartTime;
    }

    protected long getTestFinishTime() {
        return testFinishTime;
    }

    protected void setTestFinishTime(long testFinishTime) {
        this.testFinishTime = testFinishTime;
    }

    protected long getTestDurationTime() {
        return testDurationTime;
    }

    protected void setTestDurationTime(long testDurationTime) {
        this.testDurationTime = testDurationTime;
    }

    protected String getTestCaseName() {
        return testCaseName;
    }

    protected void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public String getTestFailedMsg() {
        return testFailedMsg;
    }

    public void setTestFailedMsg(String testFailedMsg) {
        this.testFailedMsg = testFailedMsg;
    }

    public void loginMobile() throws InterruptedException {
        LoginMobile login = new LoginMobile(driver);
        // fill email and password
        // login.fillEmail(ConfigDictionary.getInstance().getUsersProperties().getMobileUser());
        // login.fillPassword(ConfigDictionary.getInstance().getUsersProperties().getMobilePass());
        login.clickLoginBtn();

    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException {
        DeviceSetup.prepareDevice();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
