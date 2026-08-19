package com.skillio.pages;

import com.skillio.utils.WaitFor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.skillio.base.Keyword.*;

public class LoginPage {

    @FindBy(xpath="//input[@name=\"username\"]")   //It finds WebElement using specified locator strategy
    WebElement userNameTxtBx;

    @FindBy(xpath="//input[@name=\"password\"]")
    WebElement passwordTxtBx;

    @FindBy(xpath="//button[@type=\"submit\"]")
    WebElement loginButton;

    @FindBy(xpath="//p[text()=\"Forgot your password? \"]")
    WebElement forgotPassword;


    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void enterUserName(String userName){
        waitForUserNameToAppear();
        userNameTxtBx.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordTxtBx.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public void waitForUserNameToAppear(){
        WaitFor.visibilityOf(userNameTxtBx);
    }

}
