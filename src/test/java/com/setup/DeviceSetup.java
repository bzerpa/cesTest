package com.setup;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.common.ConfigDictionary;
import com.common.Utility.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class DeviceSetup extends BaseTestMobile {


    static AppiumDriver prepareDevice() throws MalformedURLException {

        File appDir = new File(ConfigDictionary.getInstance().getDeviceProperties().getApplicationDirectory());
        File app = new File(appDir, ConfigDictionary.getInstance().getDeviceProperties().getApplicationFile());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                ConfigDictionary.getInstance().getDeviceProperties().getPlatformVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
                ConfigDictionary.getInstance().getDeviceProperties().getOperatingSystem());
        // capabilities.setCapability(MobileCapabilityType.PLATFORM, "MAC");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                ConfigDictionary.getInstance().getDeviceProperties().getDeviceName());
        // capabilities.setCapability("udid","CE29023B-E1CC-4951-B4B6-111A005B05C3");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
                ConfigDictionary.getInstance().getDeviceProperties().getAutomationTest());
        // capabilities.setCapability("appium-version", "1.8.1");
        // capabilities.setCapability("autoAcceptAlerts",ConfigDictionary.getInstance().getDeviceProperties().getAutoAcceptAlerts());
        capabilities.setCapability(MobileCapabilityType.NO_RESET,
                ConfigDictionary.getInstance().getDeviceProperties().getNoReset());
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,
                ConfigDictionary.getInstance().getDeviceProperties().getNewCommandTimeout());
        if (ConfigDictionary.getInstance().getDeviceProperties().getOperatingSystem()
                .equalsIgnoreCase(Device.IOS.getName())) {
            driver = new IOSDriver(new URL(ConfigDictionary.getInstance().getDeviceProperties().getAppiumServerURL()),
                    capabilities);
        } else {
            driver = new AndroidDriver(
                    new URL(ConfigDictionary.getInstance().getDeviceProperties().getAppiumServerURL()), capabilities);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

}
