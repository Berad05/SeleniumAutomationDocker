package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminModulePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//li/span[contains(text(),'User Management')]")
    private WebElement drpDwnUserManagement;

    public AdminModulePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    public boolean navigationtoadminModulesuccessful()
    {
        return drpDwnUserManagement.isDisplayed();
    }

}
