package com.automation.utils.web.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomWebElement implements WebElement {

    public CustomWebElement(By byMethod) throws Exception {
        super();
        this.byMethod = byMethod;
        wait.until(ExpectedConditions.presenceOfElementLocated(byMethod));
    }

    public By byMethod;

    WebDriverWait wait = new WebDriverWait(BrowserDriver.getCurrentDriver(), Duration.ofSeconds(10));


    @Override
    public void click() {
        int currentAttempt = 1;
        while (currentAttempt <= 5) {
            try {
                System.out.println("Trying to click ... " + byMethod.toString());
                WebElement element = BrowserDriver.getCurrentDriver().findElements(byMethod).get(0);
                element.click();
                return;
            } catch (Exception exc) {
                System.out.println("Error clicking element will try again..");
            }
            currentAttempt = currentAttempt + 1;
        }

    }

    @Override
    public void submit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        System.out.println("Trying to send keys element:" + byMethod.toString());
        wait.until(ExpectedConditions.visibilityOfElementLocated(byMethod)).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        this.click();
        this.sendKeys(Keys.CONTROL + "a", Keys.COMMAND + "a");
        this.sendKeys( Keys.BACK_SPACE);
    }

    @Override
    public String getTagName() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).isEnabled();
    }

    @Override
    public String getText() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getLocation();
    }

    @Override
    public Dimension getSize() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getSize();
    }

    @Override
    public String getCssValue(String propertyName) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rectangle getRect() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDomProperty(String name) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getDomProperty(name);
    }

    @Override
    public String getDomAttribute(String name) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byMethod)).getDomAttribute(name);
    }

}
