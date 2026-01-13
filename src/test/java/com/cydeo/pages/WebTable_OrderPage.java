package com.cydeo.pages;


import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTable_OrderPage extends WebTable_Base_Page{

    public WebTable_OrderPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productSelectDropDown;

    @FindBy(xpath = "//label[text()='Visa']")
    public WebElement visaCreditCard;

    @FindBy(xpath = "//label[text()='MasterCard']")
    public WebElement masterCardCreditCard;

    @FindBy(xpath = "//label[text()='American Express']")
    public WebElement americanExpressCreditCard;

    @FindBy(name="card")
    public List<WebElement> cardTypes;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement quantityInput;

    @FindBy(xpath = "//input[@value='100']")
    public WebElement priceInput;

    @FindBy(xpath = "//input[@value='8']")
    public WebElement discountInput;

    @FindBy(xpath = "//input[@value='0']")
    public WebElement totalInput;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement streetInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement stateInput;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement zipInput;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNoInput;

    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement cardExpNoInput;

    @FindBy(xpath = "//button[text()='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//button[text()='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//button[text()='Reset Fields']")
    public WebElement resetFieldsButton;
}
