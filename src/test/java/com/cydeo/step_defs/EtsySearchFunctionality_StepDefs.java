package com.cydeo.step_defs;

import com.cydeo.pages.EtsyHome_Page;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class EtsySearchFunctionality_StepDefs {

    EtsyHome_Page etsyHome_page=new EtsyHome_Page();

    @Given("user is on the Etsy home page")
    public void user_is_on_the_etsy_home_page() {
        Driver.getDriver().get(" https://www.etsy.com");
    }
    @Then("User sees title is as expected")
    public void user_sees_title_is_as_expected() {
        String actaulTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for #everyone";

        Assert.assertEquals(expectedTitle, actaulTitle);

    }


    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsyHome_page.searchBox.sendKeys("Wooden Spoon");

    }
    @When("User clicks search button")
    public void user_clicks_search_button() {
        etsyHome_page.searchBox.click();
    }
    @Then("User sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Wooden Spoon";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String expectedTitle) {
        etsyHome_page.searchBox.sendKeys(expectedTitle);

    }


}
