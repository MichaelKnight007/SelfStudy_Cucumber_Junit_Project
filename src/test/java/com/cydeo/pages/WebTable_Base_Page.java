package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable_Base_Page {
    public WebTable_Base_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[text()='View all orders']")
    public WebElement viewAllOrdersButton;

    @FindBy(xpath = "//button[text()='View all products']")
    public WebElement viewAllProductsButton;

    @FindBy(xpath = "//button[text()='Order']")
    public WebElement orderButton;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logoutButton;


}
