package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLogin_Page {
    public VyTrackLogin_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input#prependedInput")
    public WebElement usernameField;

    @FindBy(css = "input#prependedInput2")
    public WebElement passwordField;

    @FindBy(css = "button#_submit")
    public WebElement submitButton;

    public void login(String username, String password) {
        this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.submitButton.click();
    }
}
