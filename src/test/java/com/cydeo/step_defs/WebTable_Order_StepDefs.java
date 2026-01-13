package com.cydeo.step_defs;

import com.cydeo.pages.WebTable_OrderPage;
import com.cydeo.pages.WebTable_ViewAllOrders_Page;
import com.cydeo.pages.Web_Table_Login_Cydeo_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

public class WebTable_Order_StepDefs {

    // -------------------------- Objects ------------------------
    Web_Table_Login_Cydeo_Page web_Table_Login_Cydeo_Page = new Web_Table_Login_Cydeo_Page();
    WebTable_OrderPage webTable_OrderPage = new WebTable_OrderPage();
    WebTable_ViewAllOrders_Page webTable_ViewAllOrders_Page = new WebTable_ViewAllOrders_Page();


    // ----------------- Test Step Methods ----------------

    @Given("User is already logged in entering username {string} and password {string}")
    public void userIsAlreadyLoggedInEnteringUsernameAndPassword(String username, String password) {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        web_Table_Login_Cydeo_Page.login(username, password);
    }

    @Given("user clicks Order option")
    public void user_clicks_option() {
        webTable_OrderPage.orderButton.click();
        BrowserUtils.sleep(1);


    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOrderList) {
        List<String> actualOrderList = BrowserUtils.dropdownOptions_as_STRING(webTable_OrderPage.productSelectDropDown);

        Assert.assertEquals(expectedOrderList, actualOrderList);
    }


    @Then("Then user sees below radio buttons enabled")
    public void then_user_sees_below_radio_buttons_enabled(List<String> expectedCreditCardList) {

        List<String> actualCreditCardList = new ArrayList<>();
        actualCreditCardList.add(webTable_OrderPage.visaCreditCard.getText());
        actualCreditCardList.add(webTable_OrderPage.masterCardCreditCard.getText());
        actualCreditCardList.add(webTable_OrderPage.americanExpressCreditCard.getText());

        Assert.assertTrue(webTable_OrderPage.visaCreditCard.isEnabled());
        Assert.assertTrue(webTable_OrderPage.masterCardCreditCard.isEnabled());
        Assert.assertTrue(webTable_OrderPage.americanExpressCreditCard.isEnabled());

        Assert.assertEquals(expectedCreditCardList, actualCreditCardList);

    }


    @When("user enters {string} into qauntity field")
    public void user_enters_into_qauntity_field(String quantity) {
        // webTable_OrderPage.quantityInput.clear();
        webTable_OrderPage.quantityInput.sendKeys(Keys.BACK_SPACE);
        webTable_OrderPage.quantityInput.sendKeys(quantity);
    }

    @When("user enters {string} into name field")
    public void user_enters_into_name_field(String name) {
        webTable_OrderPage.nameInput.clear();
        webTable_OrderPage.nameInput.sendKeys(name);
    }

    @When("user enters {string} into street field")
    public void user_enters_into_street_field(String street) {
        webTable_OrderPage.streetInput.clear();
        webTable_OrderPage.streetInput.sendKeys(street);
    }

    @When("user enters {string} into city field")
    public void user_enters_into_city_field(String city) {
        webTable_OrderPage.cityInput.clear();
        webTable_OrderPage.cityInput.sendKeys(city);
    }

    @When("user enters {string} into state field")
    public void user_enters_into_state_field(String state) {
        webTable_OrderPage.stateInput.clear();
        webTable_OrderPage.stateInput.sendKeys(state);
    }

    @When("user enters {string} into zip field")
    public void user_enters_into_zip_field(String zip) {
        webTable_OrderPage.zipInput.clear();
        webTable_OrderPage.zipInput.sendKeys(zip);

    }

    @When("user selects {string} card")
    public void user_selects_visa_card(String selectedCard) {

        BrowserUtils.clickRadioButton(webTable_OrderPage.cardTypes, selectedCard);

        // webTable_OrderPage.visaCreditCard.click();
    }

    @When("user enters {string} into card number field")
    public void user_enters_into_card_number_field(String cardNumber) {
        webTable_OrderPage.cardNoInput.clear();
        webTable_OrderPage.cardNoInput.sendKeys(cardNumber);
    }

    @When("user enters {string} into expiration date field")
    public void user_enters_into_expiration_date_field(String expirationDate) {
        webTable_OrderPage.cardExpNoInput.clear();
        webTable_OrderPage.cardExpNoInput.sendKeys(expirationDate);

    }

    @When("user clicks on calculate button")
    public void user_clicks_on_calculate_button() {
        webTable_OrderPage.calculateButton.click();
    }

    @When("user clicks Process Order button")
    public void user_clicks_process_order_button() {
        webTable_OrderPage.processOrderButton.click();
    }

    @Then("user sees {string} in the orders table on View all orders page")
    public void user_sees_new_order_in_the_table_on_view_all_orders_page(String expectedName) {
        String actualName = webTable_ViewAllOrders_Page.actualName.getText();
        Assert.assertEquals(expectedName, actualName);
    }

}
