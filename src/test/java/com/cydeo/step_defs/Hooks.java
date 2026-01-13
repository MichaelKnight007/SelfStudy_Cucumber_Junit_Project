package com.cydeo.step_defs;


import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    /*
    In this class we will be able to create "pre" and "post" condition for ALL of the SCENARIOS and even STEPS in the project.
     */

    @Before(order = 1) // we need to select @Before from io.cucumber.java, because it's directly implemented to Hooks. @Before is running before every scenario.
    public void setupMethod() {
        System.out.println("--> @Before: is running before every scenario");

    }

    @Before(value = "@smoke", order = 2) // We can have multiple @Before with different names. When we provide the tag as a string, this @Before will be implemented to only the scenarios having @smoke tag. We need to provide the order number in order not confusing among @Before.
    public void login_In_Hooks() {
        System.out.println("--> @Before: is running before every scenario");

    }

    @After // we need to select @After from io.cucumber.java, because it's directly implemented to Hooks. @Aterfter is running before every scenario.
    public void teardownMethod(Scenario scenario) {

        // if we want to get screenshot for ever test we can use this as it is.
        /*byte [] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        */
          //Bu if we want to use it for only failing scenarios

        if(scenario.isFailed()) {
            byte [] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        System.out.println("--> @After: is running after every scenario");
        Driver.closeDriver();
    }



 //   @BeforeStep
    // we need to select @BeforeStep from io.cucumber.java, because it's directly implemented to Hooks. @BeforeStep is running before each step.
    public void setupStep() {
        System.out.println("--> @BeforeStep is running before each step");

    }

   // @AfterStep
    // we need to select @AfterStep from io.cucumber.java, because it's directly implemented to Hooks. @AfterStep is running before each step.
    public void teardownStep() {


        System.out.println("--> @AfterStep is running before each step");

    }

 }