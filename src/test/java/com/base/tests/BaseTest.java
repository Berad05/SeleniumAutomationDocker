package com.base.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

 protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws MalformedURLException {

        String host="localhost";
        MutableCapabilities mutableCapabilities;
        if(System.getProperty("BROWSER")!=null &&
            System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
        {
            mutableCapabilities=new FirefoxOptions();

        }
        else
        {
            mutableCapabilities=new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST")!=null)
        {
            host=System.getProperty("HUB_HOST");
        }
       String completeUrl="http://"+host+":4444/wd/hub";
        this.driver=new RemoteWebDriver(new URL(completeUrl),mutableCapabilities);
    }

    @AfterTest
    public void tearDown()
    {


        this.driver.quit();
    }
}


