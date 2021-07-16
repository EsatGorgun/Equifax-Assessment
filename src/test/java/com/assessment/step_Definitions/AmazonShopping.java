package com.assessment.step_Definitions;

import com.assessment.pages.AmazonMainPage;
import com.assessment.pages.BookPage;
import com.assessment.pages.CartPage;
import com.assessment.pages.SignInPage;
import com.assessment.utilities.ConfigReader;
import com.assessment.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class AmazonShopping {

    WebDriver driver = Driver.getDriver();

    AmazonMainPage amazonMainPage = new AmazonMainPage(driver);
    BookPage bookPage = new BookPage(driver);
    CartPage cartPage = new CartPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    
    String priceInTheMainPagetoAssert = "";

    @When("Visit amazon.com")
    public void visitAmazonCom() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

    }

    @Given("Search for Book qa testing for beginners")
    public void searchForBookQaTestingForBeginners() {

        amazonMainPage.searchBar.sendKeys("qa testing for beginners");
        amazonMainPage.searchButton.click();

    }

    @Then("Click on first item in the listed results")
    public void clickOnFirstItemInTheListedResults() {
        amazonMainPage.firstBook.click();
    }

    @And("Before click on add to cart assert price from Step Three")
    public void beforeClickOnAddToCartAssertPriceFromStepThree() {

        String priceInTheMainPage = amazonMainPage.firstBookPrice.getText();
        System.out.println("First Price: " + priceInTheMainPage);

        priceInTheMainPagetoAssert = priceInTheMainPage;

        String priceInTheBookPage = bookPage.priceInBookPage.getText();
        System.out.println("Second Price: " + priceInTheBookPage);

        Assert.assertEquals(priceInTheBookPage,priceInTheMainPagetoAssert);

    }

    @Then("Click on Add to Cart")
    public void clickOnAddToCart() {
        bookPage.addToCartButton.click();
    }

    @And("Before Click on Proceed to Checkout assert price from Step Three")
    public void beforeClickOnProceedToCheckoutAssertPriceFromStepThree() {

        String priceInTheCartPage = cartPage.cartPrice.getText();
        System.out.println("priceInTheCartPage = " + priceInTheCartPage);

        Assert.assertEquals(priceInTheCartPage,priceInTheMainPagetoAssert);
    }

    @Then("Click on proceed to checkout")
    public void clickOnProceedToCheckout() {
        cartPage.checkoutButton.click();
    }

    @And("On the checkout page assert price from Step Three")
    public void onTheCheckoutPageAssertPriceFromStepThree() {

        signInPage.emailInput.sendKeys(ConfigReader.getProperty("username"));
        signInPage.continueButton.click();

        signInPage.passwordInput.sendKeys(ConfigReader.getProperty("password"));
        signInPage.signInButton.click();

        signInPage.DeliverButton.click();

        String priceInTheCheckoutPage = signInPage.checkoutPrice.getText();
        System.out.println("priceInTheCheckoutPage = " + priceInTheCheckoutPage);

        Assert.assertEquals(priceInTheCheckoutPage,priceInTheMainPagetoAssert);
    }
}
