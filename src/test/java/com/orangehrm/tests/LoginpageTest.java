package com.orangehrm.tests;

import com.base.tests.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OrangeHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseTest {

    LoginPage lp;
    OrangeHomePage homePage;

    @Test
    @Parameters({"userName","password"})
    public void validate_login_orangehrm(String userName,String password)
    {
        lp=new LoginPage(driver);
        lp.goToOrangeHRMLoginPage();
        homePage=lp.LoginOrangeHrm(userName,password);
        Assert.assertTrue(homePage.loginSuccessful().isDisplayed());
    }
}
