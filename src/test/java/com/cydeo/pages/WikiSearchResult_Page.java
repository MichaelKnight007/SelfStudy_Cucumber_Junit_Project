package com.cydeo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WikiSearchResult_Page extends Wikipaedia_page {

    @FindBy(xpath = "//h1/span[@class='mw-page-title-main']")
    public WebElement header;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;

}
