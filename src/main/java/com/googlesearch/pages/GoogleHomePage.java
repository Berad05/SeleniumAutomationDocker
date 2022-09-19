package com.googlesearch.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleHomePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
       PageFactory.initElements(driver,this);
    }

    @FindBy(name="q")
    private WebElement txtSearch;

    @FindBy(xpath="//a[contains(text(),'Videos')]")
    private WebElement lnkVideos;

    @FindBy(xpath = "//input[@value='Google Search']")
    private WebElement btnGogleSearch;

    @FindBy(xpath = "//a/h3")
    private List<WebElement> titles;

    public void goTo()
    {
        this.driver.get("https://www.google.com/");
        this.wait.until(ExpectedConditions.visibilityOf(txtSearch));
    }

    public boolean SearchResults(String searchText,String title)
    {
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
        this.wait.until(ExpectedConditions.visibilityOf(lnkVideos));
        lnkVideos.click();
       return titles.stream().anyMatch(e->e.getText().contains(title));
    }
}
