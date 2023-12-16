package com.stv.bdd.steps;

import com.stv.design.designpages.MainPage;
import com.stv.factory.factorypages.ForgotPage;
import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.stv.factory.factorytests.BasicFactoryTest.getDriver;
import static com.stv.framework.core.drivers.Driver.driver;
import static com.stv.framework.core.lib.WigglePageURLs.*;

public class AnnaTaskSteps {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    ForgotPage forgotPage = new ForgotPage();
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Given("01 Home page is open")
    public void homePageIsOpened() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainFactoryPage.clickOnTrustButton();
    }

    @When("Open the SignIn page")
    public void signInClickOn() {
        mainPage.clickOnSignInButton();
    }

    @And("Login page is opened")
    public void signInPageIsOpened() {
        loginPage.isLoginContainerDisplayed();
    }

    @When("Click on Forgot password?")
    public void forgotPasswordClickOn() {
        loginPage.clickOnForgotPassword();
    }

    @And("Forgot password page is opened")
    public void forgotPasswordPageIsOpened() {
        forgotPage.isforgotPasswordPageOpened();
    }

    @Then("^Sent \"([^\"]*)\" e-mail and continue$")
    public void sentTestEmail(String string) {
        forgotPage.sentEmail(string);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        forgotPage.clickOnContinueButton();
        forgotPage.isErrorMessageIsDisplayed();
    }

/*    @Then("Click on continue")
    public void continueClickOn() {
        forgotPage.clickOnContinueButton();
    }*/

/*    @And("Error message Email is displayed")
    public void errorMessageIsAppear() {
        forgotPage.isErrorMessageIsDisplayed();
    }*/

}


