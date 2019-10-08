package com.page.mobile;

import java.util.List;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PinCode extends BasePageMobile {
    public PinCode(AppiumDriver driver) throws InterruptedException {
        super(driver);
    }

    // @iOSFindBys(value = {
    // @iOSBy(xpath="//XCUIElementTypeApplication[@name='VetaHealth']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText")
    // })
    @AndroidFindBys(value = {@AndroidBy(xpath = "//android.widget.Button")})
    private List<WebElement> pinNumber;

    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name='US(Lbs, Oz, Ft, In)']")
    @AndroidFindBy(xpath = "(//android.widget.Button)[2]")
    private WebElement usOption;

    public void tapCodeNumber(String code) throws InterruptedException {
        selectByText(pinNumber, code);
    }
}
