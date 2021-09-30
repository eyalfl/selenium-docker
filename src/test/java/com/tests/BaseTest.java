package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        // BROWSER => Chrome / Firefox
        // HUN_HOST => localhost / 10.100.102.26 / hostname
        String host = "localhost";
        DesiredCapabilities dc;

        String browser = System.getProperty("BROWSER");
        if(browser != null) {
            if(browser.equalsIgnoreCase("firefox")) {
                dc = DesiredCapabilities.firefox();
            } else {
                dc = DesiredCapabilities.chrome();
            }
        } else {
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

        /*
        System.setProperty("webdriver.chrome.driver", "c:/eyalfl/microservices/Selenium_WebDriver_Docker_Jenkins/chromedriver.exe");
        this.driver = new ChromeDriver();
         */
    }

    @AfterTest
    public void quitDriver() {
        this.driver.quit();
    }
}
