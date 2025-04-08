package com.automation;

import com.automation.utils.web.driver.BrowserDriver;
import org.testng.annotations.Test;

public class UnitTests {


    @Test
    public void chromeDriverTest(){
        BrowserDriver.loadPage("https://google.com");

    }

    
}
