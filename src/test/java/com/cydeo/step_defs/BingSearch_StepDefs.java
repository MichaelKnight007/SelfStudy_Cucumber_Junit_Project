package com.cydeo.step_defs;

import com.cydeo.pages.BingSearch_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class BingSearch_StepDefs {

    BingSearch_Page bingSearch_page = new BingSearch_Page();

    @Given("User navigates to Bing search page")
    public void user_navigates_to_bing_search_page() {

        Driver.getDriver().get("https://www.bing.com");

    }

    @When("user enters orange into Bing search box")
    public void user_enters_orange_into_bing_search_box() {

        BrowserUtils.sleep(2);
        bingSearch_page.rejectButton.click();
        BrowserUtils.sleep(2);

        bingSearch_page.searchBox.sendKeys("orange" + Keys.ENTER);
    }

    @Then("user should see orange in the title")
    public void user_should_see_orange_in_the_title() {
        BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains("orange"));

    }

    @When("user enters {string} into Bing search box")
    public void user_enters_into_bing_search_box(String item) {
        BrowserUtils.sleep(2);
        bingSearch_page.rejectButton.click();
        bingSearch_page.searchBox.sendKeys(item, Keys.ENTER);

    }
    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String expectedTitle) {
       // BrowserUtils.sleep(2);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue( actualTitle.contains(expectedTitle));

    }
}
