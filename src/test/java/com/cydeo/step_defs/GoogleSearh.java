package com.cydeo.step_defs;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;

public class GoogleSearh {

    @When("user is on the google page")
public void user_is_on_the_google_page() {

        Driver.getDriver().get("https://www.google.com");

}
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Google";

    }
}
