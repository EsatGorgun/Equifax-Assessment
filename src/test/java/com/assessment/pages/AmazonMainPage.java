package com.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {

    public AmazonMainPage(WebDriver driver) { PageFactory.initElements(driver, this);}

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBar;

    @FindBy (id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy (xpath = "//img[@data-image-index='1']")
    public WebElement firstBook;

    @FindBy (xpath = "(//span[text()='$47.49'])[1]")
    public WebElement firstBookPrice;

}
