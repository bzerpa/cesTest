package com.mobile.tests;

import org.testng.annotations.Test;

import com.page.mobile.PinCode;
import com.setup.BaseTestMobile;

public class pinCodeTest extends BaseTestMobile {
	
    @Test
    public void basicRepeatedCode() throws InterruptedException {
        Thread.sleep(5000);
        PinCode pin = new PinCode(driver);

//        pin.enterCodeNumber("2", "2", "2", "2");
        Thread.sleep(5000);
    }

}
