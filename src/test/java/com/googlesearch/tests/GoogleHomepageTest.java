package com.googlesearch.tests;

import com.base.tests.BaseTest;
import com.googlesearch.pages.GoogleHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

     public class GoogleHomepageTest extends BaseTest {

         GoogleHomePage googleHomePage;


         @Test
         @Parameters({"SearchKeyword", "Title"})
         public void validate_title_is_present_in_SearchResult(String keyword, String title) {
             googleHomePage = new GoogleHomePage(driver);
             googleHomePage.goTo();
             boolean actual = googleHomePage.SearchResults(keyword, title);
             Assert.assertTrue(actual);
         }


     }




