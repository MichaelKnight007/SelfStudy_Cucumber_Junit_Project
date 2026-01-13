package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Web_Table_Login_Cydeo_Page {
  public  Web_Table_Login_Cydeo_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    public void login(String username, String password){
      this.usernameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();
    }
}
