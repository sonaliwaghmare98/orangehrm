package com.skillio.stepDefinitions;
import com.skillio.pages.LoginPage;
import com.skillio.pages.PIMDashboardPage;
import com.skillio.utils.WaitFor;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddEmployeeSteps {


    @And("user is logged in with valid credentials")
    public void loginToApplication(){
        LoginPage login= new LoginPage();
        login.enterUserName("Admin");
        login.enterPassword("admin123");
        login.clickLoginButton();
    }

    @When("user leaves first name field empty")
    public void fillTheFormWithBlankUserName(){
        PIMDashboardPage dashboardPage=new PIMDashboardPage();
        dashboardPage.clickPIMMenu();
        dashboardPage.clickAddEmployeeButton();
        dashboardPage.enterLastName("Waghmare");
    }

    @And("click on save button")
    public void clickOnSave(){
        PIMDashboardPage dashboardPage=new PIMDashboardPage();
        WaitFor.invisibilityOf(By.cssSelector(".oxd-form-loader"));
        dashboardPage.clickSaveButton();
    }

    @Then("user should get an error")
    public void userShouldGetAnError() {
        PIMDashboardPage dashboardPage=new PIMDashboardPage();
        String error= dashboardPage.getIsRequiredErrorMessage();
        Assert.assertEquals(error,"Required");
    }
}

