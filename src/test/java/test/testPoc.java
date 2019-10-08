package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.page.mobile.PinCode;
import com.setup.BaseTestMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class testPoc extends BaseTestMobile {

    public static AppiumDriver driver;
/*
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub


        File appDir = new File("resources/application");
        File app = new File(appDir, "com.altipeak.auth.safewalkfido.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Galaxy J7 (2016)");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("udid", "3100b164d868b3ff");
        // capabilities.setCapability("appPackage", "com.altipeak.auth");
        // capabilities.setCapability("appActivity", "com.altipeak.auth.safewlkfido.apk");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        PinCode pin = new PinCode(driver);
        pin.tapCodeNumber("3");
        pin.tapCodeNumber("4");
        pin.tapCodeNumber("5");
        pin.tapCodeNumber("8");
        Thread.sleep(5000);
        pin.tapCodeNumber("3");
        pin.tapCodeNumber("4");
        pin.tapCodeNumber("5");
        pin.tapCodeNumber("8");


    }
*/
    @Test
    public void testMethod() throws InterruptedException {
        Thread.sleep(5000);
        PinCode pin = new PinCode(driver);
        pin.tapCodeNumber("2");
        Thread.sleep(5000);
    }



}
