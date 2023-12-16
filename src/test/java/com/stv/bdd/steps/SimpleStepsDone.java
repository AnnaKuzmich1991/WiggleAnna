package com.stv.bdd.steps;

import com.stv.design.designpages.MainPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static com.stv.framework.core.lib.WigglePageURLs.START_URL;

public class SimpleStepsDone extends BasicFactoryTest {
    MainPage mainPage = new MainPage();
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @When("Home page is opened")
    public void homePageIsOpened() {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/button[2]")).click();
        mainFactoryPage.clickOnTrustButton();
    }

    @Then("Wiggle Logo is displayed")
    public void wiggleLogoIsDisplayed() {
        mainPage.isMainLogoDisplayed();
    }

    @And("Account Link is displayed")
    public void accountLinkIsDisplayed() {
        mainFactoryPage.isAccountLinkDisplayed();
    }
}


