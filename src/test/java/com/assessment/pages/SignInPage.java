package com.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    public SignInPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ap_email")
    public WebElement emailInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "ap_password")
    public WebElement passwordInput;

    @FindBy(id = "signInSubmit")
    public WebElement signInButton;

    @FindBy(partialLinkText = "Deliver to this address")
    public WebElement DeliverButton;

    @FindBy(xpath = "//span[.='$47.49 ']")
    public WebElement checkoutPrice;


}
