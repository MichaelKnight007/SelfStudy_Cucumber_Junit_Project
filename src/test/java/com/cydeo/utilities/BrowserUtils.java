package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
This class is used to create methods that can be used in this project.
 */
public class BrowserUtils {

/*
This methods gets int value for
 */
    public static void sleep(int seconds) {
        seconds=seconds*1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }

    /*
    This method gets the title of the desired URL among the opened tabs.
     */
    public static void switch_Windows( String expectedWindowURL, String expecterdTitle) {
        // driver=WebDriverFactory.getDriver("chrome");

        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String eachHandle : windowHandles) {

            Driver.getDriver().switchTo().window(eachHandle);

            String currentUrl = Driver.getDriver().getCurrentUrl();

            if (currentUrl.contains(expectedWindowURL)) {
                break;
            }

        }
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expecterdTitle));

    }


     /*
    This method gets the title of the desired URL and compares with the expected one.
     */

    public static void titleVerification( String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    /*
    This method gets the title of the desired URL verifies that  it contains expected title.
     */

    public static void verifyTitleContains( String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    /**
     * This method accepts dropdown and returns a List<String> that contains all options as String.
     * @param dropdownElement
     * @return actualOptions_as_STRING
     */
    public static List<String> dropdownOptions_as_STRING( WebElement dropdownElement) {

        Select select=new Select(dropdownElement);


        //Storing all the ACTUAL options into a list of WEB-ELEMENT
        List<WebElement> options=select.getOptions();

        // Creating an empty List of String to store ACTUAL <option> as STRING
        List<String> actualOptions_as_STRING=new ArrayList<>(); ;

        // Looping through the list of WEBELEMENT to get the ACTUAL text of options and store into List Of String
        for (WebElement eachOption : options) {
           actualOptions_as_STRING.add( eachOption.getText());

        }
        return actualOptions_as_STRING;
    }

    /**
     * This method gets a list of webelement and the value of attribute value and selects that radio button
     */

    public static void clickRadioButton( List<WebElement> radioButtons, String attributeValue) {

        for (WebElement eachRadioButton : radioButtons) {
            if (eachRadioButton.getAttribute("value").equals(attributeValue)) {
                eachRadioButton.click();
            }

        }
    }

    /**
     * This method lets you move your cursor over a webelement and hover over it.
     */
    public static void hoverOver(WebElement element) {

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }
}
