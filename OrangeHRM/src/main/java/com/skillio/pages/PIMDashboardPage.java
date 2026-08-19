package com.skillio.pages;

import com.skillio.utils.WaitFor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.skillio.base.Keyword.*;

public class PIMDashboardPage {

    @FindBy(xpath="//a[contains(@href,\"Pim\")]")
    WebElement pimMenu;

    @FindBy(xpath="//div[@class=\"orangehrm-header-container\"]/button[@type=\"button\"]")
    WebElement addEmployeeButton;

    @FindBy(xpath="//input[@name=\"firstName\"]")
    WebElement firstNameTxtBx;

    @FindBy(xpath="//input[@name=\"lastName\"]")
    WebElement lastNameTxtBx;

    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement saveButton;

    @FindBy(xpath = "(//input[contains(@placeholder,\"Type\")])[1]")
    WebElement employeeNameTxtBx;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement searchEmployeeBtn;

    @FindBy(xpath = "//span[text()=\"Required\"]")
    WebElement isRequired;

    public PIMDashboardPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void clickPIMMenu(){
        waitForPIMMenu();
        pimMenu.click();
    }
    public void clickAddEmployeeButton() {
        waitForAddEmployeeBtn();
        addEmployeeButton.click();
    }

    public void enterFirstName(String firstName) {
        waitForFistNameTxtBx();
        firstNameTxtBx.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitForLastNameTxtBx();
        lastNameTxtBx.sendKeys(lastName);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void waitForPIMMenu(){
        WaitFor.elementToBeClickable(pimMenu);
    }

    public void waitForAddEmployeeBtn(){
        WaitFor.elementToBeClickable(addEmployeeButton);
    }

    public void waitForFistNameTxtBx(){
        WaitFor.visibilityOf(firstNameTxtBx);
    }

    public void waitForLastNameTxtBx(){
        WaitFor.visibilityOf(lastNameTxtBx);
    }

    public void enterEmployeeNameToSearch(String employeeName) {
        waitForEmployeeNameTxtBx();
        employeeNameTxtBx.sendKeys(employeeName);
    }

    public void waitForEmployeeNameTxtBx(){
        WaitFor.visibilityOf(employeeNameTxtBx);
    }

    public void clickSearchButton() {
        searchEmployeeBtn.click();
    }

    public String getIsRequiredErrorMessage(){
        waitForErrorMessage();
        return isRequired.getText();
    }

    public void waitForErrorMessage(){
        WaitFor.visibilityOf(isRequired);
    }
}
