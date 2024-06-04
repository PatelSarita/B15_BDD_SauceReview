package com.sauce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage{

    @FindBy (id="first-name")
    public WebElement inputFirstName;

    @FindBy(id="last-name")
    public WebElement inputLastName;

    @FindBy(id="postal-code")
    public WebElement inputPostalCode;

    @FindBy(id="continue")
    public WebElement continueBtn;

    public void enterDetails(String firstName,String lastName,String postalCode){
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputPostalCode.sendKeys(postalCode);
        continueBtn.click();
    }
}
