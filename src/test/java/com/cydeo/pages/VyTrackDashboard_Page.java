package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashboard_Page extends VyTrackLogin_Page{

  public   VyTrackDashboard_Page(){
      PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullName;
}
