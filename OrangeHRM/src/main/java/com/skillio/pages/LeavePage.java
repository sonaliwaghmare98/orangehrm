package com.skillio.pages;

import org.openqa.selenium.By;
import static com.skillio.base.Keyword.*;
public class LeavePage {

    By leaveType= By.xpath("//div[@class=\"oxd-select-wrapper\"]/div[contains(@class,\"oxd-select-text\")]");

    public void clickOnLeaveTypeDropdown(){

        clickOn(leaveType);
    }
}
