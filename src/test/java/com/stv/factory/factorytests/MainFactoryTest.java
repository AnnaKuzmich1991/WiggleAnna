package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.stv.framework.core.lib.WigglePageURLs.*;
;

public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();
    LoginPage loginPage = new LoginPage();

    @Test (description = "Assert the main page is loaded and account icon is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
        Assert.assertEquals(actualResult, true, "Account link isn't visible");
    }

    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void assertLoginPageOpened() {
        mainFactoryPage.clickOnTrustButton();
        mainFactoryPage.clickOnAccountLink();
        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
    }

    @Test (description = "Email field is active on visit login page", dependsOnMethods = "assertLoginPageOpened")
    public void assertUsernameFocused() {
        Assert.assertEquals(new LoginPage().isElementFocused(loginPage.getUsername()), true, "Username is not focused on visiting login page");
    }

    @Test (description = "Login with not signed up user", dependsOnMethods = "assertUsernameFocused")
    public void assertValidationWithNotSignedUpUser() {
        loginPage.inputText(loginPage.getUsername(), notSignedUpUser);
        loginPage.inputText(loginPage.getPassword(), PASSWORD);
        loginPage.clickContinueButton();
        Assert.assertEquals(new LoginPage().loginValidationMessage(), "Wrong email or password", "No login validation message appears on entering wrong credentials");

    }

    @Test (description = "Login with valid value", dependsOnMethods = "assertValidationWithNotSignedUpUser")
    public void assertUserLoggedIn() {
        loginPage.getUsername().clear();
        loginPage.inputText(loginPage.getUsername(), USERNAME);
        loginPage.getPassword().clear();
        loginPage.inputText(loginPage.getPassword(), PASSWORD);
        loginPage.clickContinueButton();
        Assert.assertEquals(new LoginPage().isMyAccountButtonPresent(), true, "Login failed");

    }

}
