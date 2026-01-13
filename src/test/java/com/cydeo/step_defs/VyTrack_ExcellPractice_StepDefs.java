package com.cydeo.step_defs;

import com.cydeo.pages.VyTrackDashboard_Page;
import com.cydeo.pages.VyTrackLogin_Page;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.ExcelUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VyTrack_ExcellPractice_StepDefs {

    String path = "Vytrack_Accounts.xlsx";
    VyTrackLogin_Page vyTrackLoginPage = new VyTrackLogin_Page();
    VyTrackDashboard_Page vyTrackDashboardPage = new VyTrackDashboard_Page();
    String firstName;
    String lastName;

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @When("the user login with given credentials from {string} and {int}")
    public void the_user_login_with_given_credentials_from_and(String sheetName, Integer rowNumber) {

        ExcelUtils excelUtils = new ExcelUtils(path, sheetName);
        // Path'i kullanarak excel file'a, oradan da VyTrack sheet'ine ulaştık.

        String username = excelUtils.getCellData(rowNumber, 0);
        String password = excelUtils.getCellData(rowNumber, 1);
        firstName = excelUtils.getCellData(rowNumber, 2);
        lastName = excelUtils.getCellData(rowNumber, 3);
        // Burada sheet'ten row numberı değiştirerek her hücreden ilk sütundan username'e ve sonraki sütundan password'e, firstName ve LasrNmae'e ulaştık.

        vyTrackLoginPage.login(username, password);

    }

    @Then("the user should be able to log in and see their name")
    public void the_user_should_be_able_to_log_in_and_see_their_name() {
      //  BrowserUtils.sleep(2);

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(vyTrackDashboardPage.fullName));

        String actualFullName = vyTrackDashboardPage.fullName.getText();

        String expectedFullName = firstName + " " + lastName;

        Assert.assertEquals( expectedFullName,actualFullName);

    }
}
