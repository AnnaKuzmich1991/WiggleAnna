package com.stv.factory.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.stv.framework.core.drivers.Driver.driver;

public class ForgotPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Forgotten Password')]")
    private WebElement forgotContainer;
    @FindBy(xpath = "/html/body/div/main/section/div/div/div/form/div[2]/button")
    private WebElement continueButton;
    @FindBy(xpath = "//span[@id='error-element-email']")
    private WebElement myErrorMessage;

    public boolean isforgotPasswordPageOpened(){
        return forgotContainer.isDisplayed();
    }

    public void testEmailInput(String string) {
        WebElement myElement = driver.findElement(By.xpath("\"//input[@id='email']\""));
        myElement.sendKeys(string);
    }

    public void clickOnContinueButton(){continueButton.click();}

    public boolean isErrorMessageIsDisplayed(){
        return myErrorMessage.isDisplayed();
    }

    public void sentEmail(String string){
        WebElement myElement = driver.findElement(By.id("email"));
        myElement.sendKeys(string);
    }

}
