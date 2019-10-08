package com.interfaces;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public interface BaseTestInterface {

    public WebDriver getDriver();

    public String getTestFailedMsg();

    public void setTestFailedMsg(String testFailedMsg);

    public void setUp() throws MalformedURLException, InterruptedException, FileNotFoundException;

    public void tearDown();

}
