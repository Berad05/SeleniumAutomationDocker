package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver)
    {
         this.driver=driver;
         this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="username")
    private WebElement txtUserName;

    @FindBy(name="password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    public void goToOrangeHRMLoginPage()
    {
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.wait.until(ExpectedConditions.visibilityOf(btnLogin));
    }

    public OrangeHomePage LoginOrangeHrm(String userName, String password)
    {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
      return new OrangeHomePage(driver);
    }
}
