package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorMessage extends FactoryPage{

    @FindBy(className = "field-validation-error")
    private WebElement errorMessage;

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    //@Override
    public void sendKeys(String invalidEmail) {

    }

}
