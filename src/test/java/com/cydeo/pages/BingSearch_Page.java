package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingSearch_Page {
    public BingSearch_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "q")
   public WebElement searchBox;

    @FindBy(xpath = "//a[text()='Reject']")
    public WebElement rejectButton;

}
