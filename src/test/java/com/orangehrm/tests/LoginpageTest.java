package com.orangehrm.tests;

import com.base.tests.BaseTest;
import com.orangehrm.pages.AdminModulePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.OrangeHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseTest {

    LoginPage lp;
    OrangeHomePage homePage;
    AdminModulePage adminmodulepage;

    @Test
    @Parameters({"userName","password"})
    public void validate_login_orangehrm(String userName,String password)
    {
        lp=new LoginPage(driver);
        lp.goToOrangeHRMLoginPage();
        homePage=lp.LoginOrangeHrm(userName,password);
        Assert.assertTrue(homePage.loginSuccessful().isDisplayed());
        homePage.logout();
    }


    @Test
    @Parameters({"userName","password"})
    public void validate_navigation_to_admin_module(String userName,String password)
    {
        lp=new LoginPage(driver);
        lp.goToOrangeHRMLoginPage();
        homePage=lp.LoginOrangeHrm(userName,password);
        adminmodulepage=homePage.navigate_to_admin_module();
        Assert.assertTrue(adminmodulepage.navigationtoadminModulesuccessful());
        homePage.logout();

    }
}
