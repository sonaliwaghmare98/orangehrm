package com.skillio.base;

import com.skillio.errors.InvalidBrowserNameError;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keyword {

    public static RemoteWebDriver driver;

    public static void openBrowser(String browserName) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            throw new InvalidBrowserNameError(browserName);
        }
        System.out.println("Browser is opened successfully...!");
    }

    public static void launchUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Launching Url....!");
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public static void enterText(String locatorType, String locator, String text) {
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("name")) {
            driver.findElement(By.name(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("className")) {
            driver.findElement(By.className(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("tagName")) {
            driver.findElement(By.tagName(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("linkText")) {
            driver.findElement(By.linkText(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("partialLinkText")) {
            driver.findElement(By.partialLinkText(locator));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        } else {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }
    }

    public static void clickOn(String locatorType, String locator) {
        if (locatorType.equalsIgnoreCase("id")) {
            driver.findElement(By.id(locator)).click();
        } else if (locatorType.equalsIgnoreCase("name")) {
            driver.findElement(By.name(locator)).click();
        } else if (locatorType.equalsIgnoreCase("className")) {
            driver.findElement(By.className(locator)).click();
        } else if (locatorType.equalsIgnoreCase("tagName")) {
            driver.findElement(By.tagName(locator)).click();
        } else if (locatorType.equalsIgnoreCase("linkText")) {
            driver.findElement(By.linkText(locator)).click();
        } else if (locatorType.equalsIgnoreCase("partialLinkText")) {
            driver.findElement(By.partialLinkText(locator));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            driver.findElement(By.xpath(locator)).click();
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            driver.findElement(By.cssSelector(locator)).click();
        } else {
            driver.findElement(By.xpath(locator)).click();
        }

    }

    public static void clickOn(By element){
        driver.findElement(element).click();
    }
}
