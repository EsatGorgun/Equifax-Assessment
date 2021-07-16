package com.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
    public WebElement cartPrice;

    @FindBy(id = "hlb-ptc-btn-native")
    public WebElement checkoutButton;
}
