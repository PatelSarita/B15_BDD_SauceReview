package com.sauce.stepDefs;

import com.sauce.pages.*;
import com.sauce.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class EndtoEnd_StepDefs {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    CartPage cartPage = new CartPage();
    CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage();

    CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    @When("The user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {
        loginPage.login(username, password);

    }

    @Then("The user should be able to login and see {string} header")
    public void theUserShouldBeAbleToLoginAndSeeHeader(String expectedHeader) {
        assertEquals(expectedHeader, productsPage.productsText.getText());
    }

    @When("The user sorts the products by {string}")
    public void theUserSortsTheProductsBy(String shortType) {
        productsPage.sortProduct(shortType);

    }

    @And("The user adds the cheapest product as {string}and the second costliest products as {string}")
    public void theUserAddsTheCheapestProductAsAndTheSecondCostliestProductsAs(String cheapest, String secondCost) {

        productsPage.addProducts(cheapest);
        productsPage.addProducts(secondCost);
    }

    @And("The user opens the basket")
    public void theUserOpensTheBasket() {
        productsPage.cartBtn.click();

    }

    @And("The user clicks checkout button")
    public void theUserClicksCheckoutButton() {
        cartPage.checkoutBtn.click();
    }

    @And("The user enters details as {string} and {string} and {string} and clicks continue button")
    public void theUserEntersDetailsAsAndAndAndClicksContinueButton(String firstName, String lastName, String postalCode) {
        checkoutStepOnePage.enterDetails(firstName, lastName, postalCode);
    }


    @Then("The user verifies that the total price is {string}")
    public void theUserVerifiesThatTheTotalPriceIs(String expectedPrice) {
        assertEquals(expectedPrice,checkoutStepTwoPage.priceTotal.getText());
    }

    @When("The user clicks on finish button")
    public void theUserClicksOnFinishButton() {
        BrowserUtils.waitFor(1);
        checkoutStepTwoPage.finishBtn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("The user should be able to see confirmation message as {string}")
    public void theUserShouldBeAbleToSeeConfirmationMessageAs(String expectedMsg) {
        BrowserUtils.waitFor(1);
        assertEquals(expectedMsg,checkoutCompletePage.completeMsg.getText());
    }
}
