package com.skillio.base;

import com.skillio.errors.InvalidBrowserNameError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Set;

public class Keyword {

    static ThreadLocal<RemoteWebDriver> storage = new ThreadLocal<>();

    public static void setDriver(RemoteWebDriver driver) {
        storage.set(driver);
    }

    public static RemoteWebDriver getDriver() {
        return storage.get();
    }

    public static void openBrowser(String browserName) {

        RemoteWebDriver driver = null;

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            throw new InvalidBrowserNameError(browserName);
        }
        setDriver(driver);
        System.out.println("Browser is opened successfully...!");
    }

    public static void launchUrl(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        System.out.println("Launching Url....!");
    }

    public static void closeBrowser() {
        getDriver().quit();
    }

    public static WebElement getWebElement(String locatorType, String locator){
        if (locatorType.equalsIgnoreCase("id")) {
            return getDriver().findElement(By.id(locator));
        } else if (locatorType.equalsIgnoreCase("name")) {
            return getDriver().findElement(By.name(locator));
        } else if (locatorType.equalsIgnoreCase("className")) {
            return getDriver().findElement(By.className(locator));
        } else if (locatorType.equalsIgnoreCase("tagName")) {
            return getDriver().findElement(By.tagName(locator));
        } else if (locatorType.equalsIgnoreCase("linkText")) {
            return getDriver().findElement(By.linkText(locator));
        } else if (locatorType.equalsIgnoreCase("partialLinkText")) {
            return getDriver().findElement(By.partialLinkText(locator));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            return getDriver().findElement(By.xpath(locator));
        } else if (locatorType.equalsIgnoreCase("cssSelector")) {
            return getDriver().findElement(By.cssSelector(locator));
        } else {
            return getDriver().findElement(By.xpath(locator));
        }
    }
    public static void enterText(String locatorType, String locator, String text) {
        getWebElement(locatorType,locator).sendKeys(text);
    }

    public static void clickOn(String locatorType, String locator) {
        getWebElement(locatorType,locator).click();
    }

    public static void clickOn(By element) {
        getDriver().findElement(element).click();
    }

    public static void switchToWindow(String title){
        Set<String> windwos=getDriver().getWindowHandles();
        for (String window:windwos){
            getDriver().switchTo().window(window);
            if(getDriver().getTitle().equalsIgnoreCase(title)){
                break;
            }
        }
    }
}
