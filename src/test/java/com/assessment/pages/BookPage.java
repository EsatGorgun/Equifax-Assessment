package com.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage {

    public BookPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "newBuyBoxPrice")
    public WebElement priceInBookPage;

    @FindBy(id="add-to-cart-button")
    public WebElement addToCartButton;


}
