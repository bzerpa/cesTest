package com.page.mobile;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.common.ConfigDictionary;
import com.interfaces.BasePageInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;


class BasePageMobile implements BasePageInterface {



    public AppiumDriver driver;
    public WebDriverWait wait;


    // Constructor
    public BasePageMobile(AppiumDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(3000);
        // wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        // PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOf(element));
        Thread.sleep(3000);
        element.click();
    }

    void back() throws InterruptedException {
        driver.navigate().back();
    }

    String getText(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    String getValue(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute("value");
    }

    int getSize(List<WebElement> elements) throws InterruptedException {
        if (!elements.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
            return elements.size();
        }
        return 0;
    }

    void clearText(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
    }

    void movePointerToTheRight(WebElement element) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        TouchAction action = new TouchAction(driver);
        action.tap(new PointOption().withCoordinates(element.getLocation().x + element.getSize().width - 10,
                element.getLocation().y + element.getSize().height - 10)).release().perform();
    }

    public void swipeFromBottomToUp() {
        TouchAction action = new TouchAction(driver);
        action.longPress(longPressOptions().withPosition(new PointOption().withCoordinates(138, 440)))
                .moveTo(new PointOption().withCoordinates(138, 340)).release().perform();
    }

    boolean selectHealthLogValue(List<WebElement> elements, String text) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        int index = 0;
        for (WebElement webElement : elements) {
            if (webElement.getAttribute("value").contentEquals(text)) {
                while (!elements.get(index).isDisplayed()) {
                    swipeFromBottomToUp();
                }
                elements.get(index).click();
                return true;
            }
            index++;
        }
        return false;
    }

    // Probably we will need to adapt this function like the function above
    boolean selectHealthLogText(List<WebElement> elements, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        for (WebElement webElement : elements) {
            // System.out.println(webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).getText() +
            // text);
            // System.out.println(webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).getText());
            if (webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).getText()
                    .equalsIgnoreCase(text)) {
                webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).click();
                return true;
            }
        }
        return false;
    }

    boolean healthLogHasNoRecord(List<WebElement> elements, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        Thread.sleep(3000);
        for (WebElement webElement : elements) {
            // System.out.println(webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).getText());
            if (webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).getText()
                    .equalsIgnoreCase(text)) {
                while (!webElement.findElement(By.id("com.vetahealth.android:id/statusItemTitle")).isDisplayed()) {
                    swipeFromBottomToUp();
                }
                if (webElement.findElement(By.id("com.vetahealth.android:id/statusItemStats")).getAttribute("text")
                        .equalsIgnoreCase("No values taken yet"))
                    return true;
                else
                    return false;
            }
        }
        return false;
    }

    boolean selectByText(List<WebElement> elements, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        Thread.sleep(3000);
        // wait.until(ExpectedConditions.visibilityOf(elements.get(0)));
        for (WebElement webElement : elements) {
            // System.out.println(webElement.getText());
            if (webElement.getText().equalsIgnoreCase(text)) {
                click(webElement);
                return true;
            }
        }
        return false;
    }

    boolean isEnableElement(WebElement element) throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(element));
        // Assert.assertTrue(element.isEnabled(), "The element is not displayed/enabled.");
        return element.isEnabled();
    }

    boolean isClickableElement(WebElement element) throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(element));
        // Assert.assertTrue(element.isEnabled(), "The element is not displayed/enabled.");
        return element.getAttribute("clickable").contains("true");
    }

    boolean isVisibleElement(WebElement element) throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(element));
        // Assert.assertTrue(element.isEnabled(), "The element is not displayed/enabled.");
        return (element.getAttribute("visible").toString().equalsIgnoreCase("true")) ? true : false;
    }

    boolean isDisplayedElement(WebElement element) throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(element));
        // Assert.assertTrue(element.isEnabled(), "The element is not displayed/enabled.");
        return element.isDisplayed();
    }

    public String sliderValueToOnOff(String value) {
        // if (value.equalsIgnoreCase("1")) {
        // return "ON";
        // } else {
        // return "OFF";
        // }
        return (value.equalsIgnoreCase("1")) ? "ON" : "OFF";
    }

    void assertText(WebElement element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getText(), text, "The text " + text + " is not equals to " + element.getText());
    }

    void assertTextByAttribute(WebElement element, String attribute, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute(attribute).toString(), text,
                "The text " + text + " is not equals to " + element.getAttribute(attribute).toString());
    }

    void assertTextToast(WebElement element, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute("name"), text,
                "The text " + text + " is not equals to " + element.getText());
    }

    void assertNumbersNotEquals(int actual, int expected) {

        Assert.assertNotEquals(actual, expected, "The values [" + actual + "] and [" + expected + "] are equals.");
    }

    void assertNumbersEquals(int actual, int expected) {

        Assert.assertEquals(actual, expected, "The values [" + actual + "] and [" + expected + "] are not equals.");
    }

    void assertTextNotEquals(String actual, String expected) {

        Assert.assertNotEquals(actual, expected, "The values [" + actual + "] and [" + expected + "] are equals.");
    }

    void assertTextValue(WebElement element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertEquals(element.getAttribute("value"), text,
                "The text " + text + " is not equals to " + element.getAttribute("value"));
    }

    boolean isTextValue(WebElement element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        return (element.getAttribute("value").equalsIgnoreCase(text)) ? true : false;
    }

    void assertSubstring(WebElement element, String text) throws InterruptedException {

        if (!ConfigDictionary.getInstance().getDeviceProperties().getOperatingSystem().equalsIgnoreCase("iOS"))
            Assert.assertTrue(element.getText().contains(text),
                    "The text " + element.getText() + " doesn't contain the string " + text);
        else
            Assert.assertTrue(element.getAttribute("value").contains(text),
                    "The text " + element.getAttribute("value") + " doesn't contain the string " + text);
    }

    boolean isTextInTheList(List<WebElement> usersInformationList, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOf(usersInformationList.get(2)));
        for (WebElement webElement : usersInformationList) {
            if (webElement.getAttribute("label").contentEquals(text)) {
                return true;
            }
        }
        return false;
    }

    boolean isTextInTheList(List<WebElement> usersInformationList, List<WebElement> dateList, String text, String date)
            throws InterruptedException {
        // wait.until(ExpectedConditions.visibilityOf(usersInformationList.get(2)));
        int i = 0;
        for (WebElement webElement : usersInformationList) {
            if (webElement.getAttribute("label").contentEquals(text)
                    && dateList.get(i).getAttribute("label").contains(date)) {
                return true;
            }
            i++;
        }
        return false;
    }

    boolean isTextInTheListByText(List<WebElement> usersInformationList, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(usersInformationList.get(0)));
        for (WebElement webElement : usersInformationList) {
            if (webElement.getText().contentEquals(text)) {
                return true;
            }
        }
        return false;
    }

    boolean isTextContainsInTheList(List<WebElement> usersInformationList, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(usersInformationList.get(2)));
        for (WebElement webElement : usersInformationList) {
            if (webElement.getAttribute("label").contains(text)) {
                return true;
            }
        }
        return false;
    }

    boolean isTextContainsInTheListByText(List<WebElement> usersInformationList, String text)
            throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(usersInformationList.get(0)));
        for (WebElement webElement : usersInformationList) {
            if (webElement.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    boolean selectByTextContains(WebElement element, String text) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(element));
        if (element.getText().contains(text)) {
            return true;
        }
        return false;
    }

    protected void sendKey(WebElement element, String text) throws InterruptedException {
        // wait.until(ExpectedConditions.elementToBeClickable(element));
        // wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void hideAndroidKeyboard() throws InterruptedException {
        driver.hideKeyboard();
    }


    public void selectDateAndroid(WebElement previousMonth, WebElement nextMonth, WebElement yearLabel,
            List<WebElement> yearList, WebElement dateLabel, WebElement dayView, String month, String day, String year)
            throws InterruptedException {

        click(yearLabel);
        TouchAction action = new TouchAction(driver);
        while (!selectByText(yearList, year)) {
            action.longPress(longPressOptions().withElement(element(yearList.get(0))))
                    .moveTo(element(yearList.get(yearList.size() - 1))).release().perform();
        }
        List<WebElement> days = dayView.findElements(By.className("android.view.View"));
        while (!selectByTextContains(dateLabel, month)) {
            click(previousMonth);
            days = dayView.findElements(By.className("android.view.View"));
            days.get(0).click();
        }
        selectByText(days, day);
    }

    protected void assertElementPresentDisabled(WebElement element) {

        Assert.assertTrue(element.getAttribute("clickable").equalsIgnoreCase("false"),
                "Excepted to be false, now i get " + element.getAttribute("clickable"));

        // Assert.assertEquals(element.isEnabled(), false, "Excepted to be false, now I get " + element.isEnabled());

    }
}
