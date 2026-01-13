package com.cydeo.step_defs;

import com.cydeo.pages.Web_Table_Login_Cydeo_Page;
import com.cydeo.utilities.Driver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class Web_Table_Login_Cydeo_StepDefs {

    // --------------------- OBJECTS -----------------------
    Web_Table_Login_Cydeo_Page web_Table_Login_Page = new Web_Table_Login_Cydeo_Page();


    @When("user goes to URL")
    public void user_goes_to_url() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    @When("user enters correct username into username field")
    public void user_enters_username_into_username_field() {
        web_Table_Login_Page.usernameField.sendKeys("Test");

    }

    @When("user enters correct password into password field")
    public void user_enters_password_into_password_field() {
        web_Table_Login_Page.passwordField.sendKeys("Tester" + Keys.ENTER);
    }

    @Then("user should see that URL ends with orders")
    public void user_url_should_end_with_orders() {
        String currentUrl = Driver.getDriver().getCurrentUrl();
        String expectedInURL="orders";

        Assert.assertTrue(currentUrl.contains(expectedInURL));

    }

    @When("user enters valid {string} into username field")
    public void user_enters_into_username_field(String username) {
        web_Table_Login_Page.usernameField.sendKeys(username);

    }
    @When("user enters valid {string} into password field")
    public void user_enters_into_password_field(String password) {
        web_Table_Login_Page.passwordField.sendKeys(password);

    }

    @When("user enters valid credentials")
    public void user_Enters_Valid_Credentials(Map<String, String> credentials) {
        web_Table_Login_Page.usernameField.clear();
        web_Table_Login_Page.passwordField.clear();

        web_Table_Login_Page.usernameField.sendKeys(credentials.get("username"));
        web_Table_Login_Page.passwordField.sendKeys(credentials.get("password"));
        web_Table_Login_Page.loginButton.click();

    }
}
