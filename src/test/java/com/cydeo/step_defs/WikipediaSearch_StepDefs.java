package com.cydeo.step_defs;

import com.cydeo.pages.WikiSearchResult_Page;
import com.cydeo.pages.Wikipaedia_page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class WikipediaSearch_StepDefs {

    Wikipaedia_page wikipaedia_page=new Wikipaedia_page();
    WikiSearchResult_Page wikiSearchResult_page=new WikiSearchResult_Page();

    @Given("User types {string} in the wiki search box and clicks search button")
    public void user_types_in_the_wiki_search_box_and_clicks_search_button(String searchValue) {
        wikipaedia_page.wikiSearchMethod(searchValue);
    }

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String expectedSearchValue) {
        BrowserUtils.sleep(2);
        wikipaedia_page.searchInputBox.sendKeys(expectedSearchValue);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchResult_page.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String expectedTitle) {
        BrowserUtils.sleep(2);

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String expectedHeader) {
        String actualHeader = wikiSearchResult_page.header.getText();
        Assert.assertTrue(actualHeader.equals(expectedHeader));
    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String expectedImageHeader) {
        String actualImageHeader = wikiSearchResult_page.imageHeader.getText();
        Assert.assertTrue(actualImageHeader.equals(expectedImageHeader));
    }





}
