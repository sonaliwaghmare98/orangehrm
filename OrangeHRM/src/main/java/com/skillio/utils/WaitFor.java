package com.skillio.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import static com.skillio.base.Keyword.*;

public abstract class WaitFor {
    static WebDriverWait wait;

    static{
         wait=new WebDriverWait(getDriver(), Duration.ofSeconds(60));
         wait.pollingEvery(Duration.ofMillis(500));
         wait.ignoring(NoSuchElementException.class);
    }
    public static void visibilityOf(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void visibilityOf(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void elementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void elementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void invisibilityOf(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
