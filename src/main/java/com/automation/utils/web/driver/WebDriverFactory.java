package com.automation.utils.web.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;

    public class WebDriverFactory {

        public enum DriverType {
            CHROME
        }

        public static WebDriver createDriver() {
            return createDriver(DriverType.CHROME);
        }

        public static WebDriver createDriver(DriverType type){
            return createDriver(type, null);
        }

        public static WebDriver createDriver(DriverType type, Proxy proxy){
            return createDriver(type, proxy, null);
        }

        public static WebDriver createDriver(DriverType type, Proxy proxy, ChromeOptions customOptions){
            WebDriver driver = null;
            switch (type) {
                case CHROME:
                    driver = getChromeHeadlessDriver(customOptions);
                    break;
                default:
                    break;
            }
            return driver;
        }

        private synchronized static WebDriver getChromeHeadlessDriver(ChromeOptions customOptions) {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("ignore-certificate-errors"));
            Properties configProperties = new Properties();
            if(System.getProperty("headless") == null || System.getProperty("headless").equalsIgnoreCase("true")) {
                chromeOptions.addArguments("--headless");
            }

            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-web-security");
            chromeOptions.addArguments("--remote-allow-origins=*");

            chromeOptions.addArguments("--allow-running-insecure-content");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--reduce-security-for-testing");
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--enable-logging --v=1");
            chromeOptions.addArguments("--user-agent="
                    + "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36");
            chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            if (customOptions != null) {
                chromeOptions = chromeOptions.merge(customOptions);
            }
            WebDriverManager.chromedriver().setup();
            ChromeDriver chrome_driver= new ChromeDriver(chromeOptions);
            chrome_driver.manage().window().maximize();
            chrome_driver.setLogLevel(Level.ALL);
            System.out.println("Runnnning on Chrome:"  + chrome_driver.getCapabilities().getCapability("browserVersion"));
            return chrome_driver;
        }

}
