package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//input[@placeholder='Search']")
    private WebElement txtSearch;

    public OrangeHomePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    public WebElement loginSuccessful()
    {
        return this.wait.until(ExpectedConditions.visibilityOf(txtSearch));
    }
}
