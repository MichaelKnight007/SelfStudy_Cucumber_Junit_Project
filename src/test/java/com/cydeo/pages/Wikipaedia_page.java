package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wikipaedia_page {
    public Wikipaedia_page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#searchInput")
    public WebElement searchInputBox;

    @FindBy(xpath = "//i[text()='Search']")
    public WebElement searchButton;


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public void wikiSearchMethod(String searchText){
        Driver.getDriver().get("https://www.wikipedia.org/");
        wait.until(ExpectedConditions.visibilityOf(searchInputBox));
        //BrowserUtils.sleep(1);
        searchInputBox.sendKeys(searchText);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
       // BrowserUtils.sleep(1);
        searchButton.click();
    }


}
