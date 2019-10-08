package com.page.mobile;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.offset.PointOption;


public class LoginMobile extends BasePageMobile {
    public LoginMobile(AppiumDriver driver) throws InterruptedException {
        super(driver);
    }

    // @FindBy(id="loginBtn")
    @iOSFindBy(id = "loginBtn")
    @AndroidFindBy(id = "com.vetahealth.android:id/btnText")
    private WebElement loginBtn;

    // @iOSFindBy(id="need this selector")
    @AndroidFindBy(id = "com.vetahealth.android:id/tvNotNow")
    private WebElement notNowBtn;

    // @iOSFindBy(id="need this selector")
    @AndroidFindBy(id = "com.vetahealth.android:id/skipButton")
    private WebElement skipBtn;

    // @iOSFindBy(id="need this selector")
    @AndroidFindBy(id = "com.vetahealth.android:id/set_pin")
    private WebElement newPinField;

    // @iOSFindBy(id="need this selector")
    @AndroidFindBy(id = "com.vetahealth.android:id/confirm_pin")
    private WebElement confirmNewPinField;

    // @iOSFindBy(id="need this selector")
    @AndroidFindBy(id = "com.vetahealth.android:id/ok_button")
    private WebElement okNewPinBtn;

    @FindBy(id = "Allow")
    private WebElement allowBtn;

    // @FindBy(id="enviromentInput")
    @iOSFindBy(id = "enviromentInput")
    @AndroidFindBy(id = "com.vetahealth.android:id/spApiUrls")
    private WebElement enviromentInput;

    // @FindBy(className="XCUIElementTypePickerWheel")
    @iOSFindBy(className = "XCUIElementTypePickerWheel")
    @AndroidFindBy(xpath = "//android.widget.TextView[2]")
    private WebElement pickerValue;

    @iOSFindBy(id = "enviromentInput")
    private WebElement environmentField;

    @FindBy(id = "Toolbar Done Button")
    private WebElement pickerDoneBtn;

    // @FindBy(id="forgotPasswordBtn")
    @iOSFindBy(id = "forgotPasswordLabel")
    @AndroidFindBy(id = "com.vetahealth.android:id/tvForgotPass")
    private WebElement forgotPasswordBtn;

    // @FindBy(id="logoImg")
    @iOSFindBy(id = "logoImg")
    @AndroidFindBy(xpath = "//android.widget.ImageView")
    // @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.View[1]/android.widget.ImageView")
    private WebElement logoImg;

    // @FindBy(id="custom_alert")
    @iOSFindBy(id = "custom_alert")
    @AndroidFindBy(id = "android:id/message")
    private WebElement alertText;

    // @FindBy(id="Ok")
    @iOSFindBy(id = "Ok")
    @AndroidFindBy(id = "android:id/button1")
    private WebElement okBtn;

    // @FindBy(id="emailInput")
    @iOSFindBy(id = "emailInput")
    @AndroidFindBy(id = "com.vetahealth.android:id/edEmail")
    private WebElement emailField;

    @AndroidFindBys(value = {@AndroidBy(id = "com.vetahealth.android:id/textinput_error")})
    private List<WebElement> errorText;

    // @FindBy(id="passwordInput")
    @iOSFindBy(id = "passwordInput")
    @AndroidFindBy(id = "com.vetahealth.android:id/edPass")
    private WebElement passwordField;

    // @FindBy(id="userNameLabel")
    @iOSFindBy(id = "userNameLabel")
    @AndroidFindBy(id = "com.vetahealth.android:id/welcome_user_name")
    private WebElement userName;

    // @FindBy(id="forgotPasswordLabel")
    @iOSFindBy(id = "forgotPasswordLabel")
    @AndroidFindBy(id = "com.vetahealth.android:id/forgotPass_title")
    private WebElement forgotPasswordTitle;

    // @Step("LoginPage")
    public void assertLogoInLoginPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isEnableElement(logoImg), "The element is not displayed/enabled.");

    }

    // @Step("ClearUserField")
    public void clearEmailField() throws InterruptedException {

        clearText(emailField);

    }

    // @Step("ClearPasswordField")
    public void clearPasswordField() throws InterruptedException {

        clearText(passwordField);

    }

    // @Step("ClickOnLogin")
    public void clickLoginBtn() throws InterruptedException {

        click(loginBtn);
    }

    public void clickOkNewPinBtn() throws InterruptedException {
        hideAndroidKeyboard();
        click(okNewPinBtn);
    }

    public void clickNotNowBtn() throws InterruptedException {

        click(notNowBtn);
    }

    public void clickSkipBtn() throws InterruptedException {

        click(skipBtn);
    }

    // @Step("Click on Allow")
    public void clickAllowBtn() throws InterruptedException {

        click(allowBtn);
        // allowBtn.click();
    }

    // @Step("Click on forgot password button")
    public void clickForgotPassBtn() throws InterruptedException {

        click(forgotPasswordBtn);
    }

    // @Step("AlertIsDisplayed with an specific text")
    public void assertAlertIsDisplayed(String text) throws InterruptedException {
        Thread.sleep(1000);
        assertTextValue(alertText, text);

    }

    // @Step("AlertIsDisplayed with an specific text")
    public void assertAlertIsDisplayedAndroid(String text) throws InterruptedException {

        assertText(alertText, text);

    }

    // @Step("Check the forgot password title with the text")
    public void assertForgotPassTitle(String text) throws InterruptedException {

        assertText(forgotPasswordTitle, text);

    }

    // @Step("User name with an specific text")
    public void assertUserName(String text) throws InterruptedException {

        assertText(userName, text);

    }

    // @Step("Check the email error with an specific text")
    public void assertEmailErrorText(String text) throws InterruptedException {

        // assertText(errorText.get(0), text);
        isTextInTheListByText(errorText, text);

    }

    // @Step("Check the password error with an specific text")
    public void assertPasswordErrorText(String text) throws InterruptedException {

        isTextInTheListByText(errorText, text);

    }

    // @Step("CloseAlert")
    public void closeAlert() throws InterruptedException {

        click(okBtn);

    }

    // @Step("Fill user field")
    public void fillEmail(String email) throws InterruptedException {

        sendKey(emailField, email);

    }

    public void fillNewPin(String pin) throws InterruptedException {

        sendKey(newPinField, pin);

    }

    public void fillConfirmNewPin(String pin) throws InterruptedException {

        sendKey(confirmNewPinField, pin);

    }

    // @Step("Select environment")
    public void selectEnvironment(String environment) throws InterruptedException {

        click(enviromentInput);
        // sendKey(pickerValue, environment);
        // if (!isTextValue(pickerValue, environment)) {
        // TouchAction action = new TouchAction(driver);
        // action.longPress(longPressOptions().withPosition(new PointOption().withCoordinates(192, 622))).moveTo(new
        // PointOption().withCoordinates(192, 562)).release().perform();
        // sendKey(pickerValue, environment);
        //// }
        // if (!isTextValue(pickerValue, environment)) {
        // sendKey(pickerValue, environment);
        // System.out.print("Entro aca!!!!");
        // }
        environment(environment);
        // click(pickerDoneBtn);

    }

    public void environment(String environment) throws InterruptedException {
        if (!isTextValue(environmentField, environment)) {
            TouchAction action = new TouchAction(driver);
            action.longPress(longPressOptions().withPosition(new PointOption().withCoordinates(192, 622)))
                    .moveTo(new PointOption().withCoordinates(192, 562)).release().perform();
            sendKey(pickerValue, environment);
            environment(environment);
        } else {
            click(pickerDoneBtn);
        }
    }

    // @Step("Select environment")
    public void selectEnvironment() throws InterruptedException {

        click(enviromentInput);
        click(pickerValue);

    }

    // @Step("Fill password field")
    public void fillPassword(String pass) throws InterruptedException {

        sendKey(passwordField, pass);

    }

    public String getEnviromentValue() throws InterruptedException {
        return enviromentInput.getAttribute("value");
    }
}
