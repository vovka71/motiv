package com.automation.utils.web.driver;

import com.automation.utils.TestUtils;
import org.openqa.selenium.*;

public class BrowserDriver {

    private static WebDriver driver;
    public static Object status;


    public synchronized static WebDriver getCurrentDriver() {
        if (driver == null) {
            if (System.getProperty("driver") == null || System.getProperty("driver").equals("chrome")) {
                driver = WebDriverFactory.createDriver();
            }
            driver.manage().window().setSize(new Dimension(2560, 1440));

            Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
        }
        return driver;
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }

    public static synchronized void close() {
        if (driver != null) {
            try {
                getCurrentDriver().close();
                getCurrentDriver().quit();
                System.out.println("Closing browser .. ");
            } catch (Exception e) {
                System.out.println("cannot close browser: unreachable browser");
            } finally {
                driver = null;
            }
        }
    }

    public static void loadPage(String url) {
        System.out.println("Loading page: " + url);
        getCurrentDriver().get(url);
    }

    public static WebElement findElement(By byMethod) throws Exception {
        return new CustomWebElement(byMethod);
    }


}
