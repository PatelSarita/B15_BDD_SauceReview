package com.sauce.stepDefs;

import com.sauce.pages.LoginPage;
import com.sauce.pages.ProductsPage;
import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.ConfigurationReader;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("The user enters {string} and {string} credentials")
    public void the_user_enters_and_credentials(String username, String password) {
        loginPage.login(username, password);

    }

    @Then("The user should be able to login sauce demo website")
    public void the_user_should_be_able_to_login_sauce_demo_website() {
        //assertEquals("Products",productsPage.productsText.getText());
        assertTrue(productsPage.productsText.isDisplayed());
        //  BrowserUtils.verifyElementDisplayed(productsPage.productsText);
    }

    @When("The user enters invalid or empty {string} and {string} credentials")
    public void the_user_enters_invalid_or_empty_and_credentials(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user should see the {string}")
    public void the_user_should_see_the(String expectedMsg) {
        assertEquals(expectedMsg,loginPage.errorMsg.getText());

    }
}