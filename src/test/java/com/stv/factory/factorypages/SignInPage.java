package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.stv.framework.core.lib.SignInEmail.INVALID_EMAIL;


public class SignInPage extends FactoryPage {

    @FindBy(id = "LogOnModel_UserName")
    private WebElement signInEmailField;

    @FindBy(id = "LogOnModel_Password")
    private WebElement passwordField;

    public void signInEmailInput(){ signInEmailField.sendKeys(INVALID_EMAIL);}

    public void goToPasswordField(){ passwordField.click(); }

   // @Override
    public void sendKeys(String string) {

    }

}

