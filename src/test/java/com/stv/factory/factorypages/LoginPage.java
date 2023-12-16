package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.stv.framework.core.drivers.Driver.driver;

public class LoginPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Please log in')]")
    private WebElement loginContainer;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    public WebElement getUsername(){
        return username;
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    public WebElement getPassword(){
        return password;
    }
    @FindBy(xpath = "//button[not(contains(@style,'visibility: hidden'))][@type='submit'] ")
    public WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Forgot password')]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    private WebElement signup;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signin;

    @FindBy(xpath = "//button[@aria-label='My account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//span[@id='error-element-password']")
    private WebElement loginValidationMessage;
    @FindBy(xpath = "//a[@class='c11ad22cc c58f27bb1 c1ec6096e']")
    private WebElement forgotPasswordButton;

    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public boolean isElementFocused(WebElement element){
        return element.equals(driver.switchTo().activeElement());
    }

    public void inputText(WebElement el, String text){
        el.sendKeys(text);
    }
    public String loginValidationMessage(){
        return loginValidationMessage.getText();
    }
    public void clickContinueButton(){continueButton.click();}
    public void clickOnForgotPassword(){forgotPasswordButton.click();}
    public void isValidationMessagePresentOnInvalidCredentials(){

}
    public boolean isMyAccountButtonPresent(){
        return myAccountButton.isDisplayed();
    }

}
