package com.automation;

import com.automation.utils.web.driver.BrowserDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UnitTests {


    @Test
    public void chromeDriverTest() throws Exception {

        BrowserDriver.loadPage("https://google.com");
        BrowserDriver.findElement(new By.ByName("q"));
    }


}
