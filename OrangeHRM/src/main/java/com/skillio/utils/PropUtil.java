package com.skillio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
    private final String filePath;

    public PropUtil(String filePath){
        this.filePath=filePath;
    }

    public String getProperty(String key){
        String value = "";
        try{
            FileInputStream fis = new FileInputStream(filePath);
            Properties prop = new Properties();
            prop.load(fis);

            value=prop.getProperty(key);

        }catch(FileNotFoundException e){
            System.err.println("OR.properties is not readable.");
        }catch (IOException e){
            System.err.println("Unable to load properties file.");
        }
        return value;
    }


}
