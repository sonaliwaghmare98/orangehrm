package com.skillio.utils;

public class OR {
    public static final String filePath="D:\\Sonali\\IntellijSelenium\\OrangeHRM\\src\\main\\resources\\OR.properties";

    public static String getLocator(String locator){
        PropUtil propUtil=new PropUtil(filePath);
        return propUtil.getProperty(locator);
    }
}
