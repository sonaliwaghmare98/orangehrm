package com.skillio.errors;

public class InvalidBrowserNameError extends Error {
    String browserName;

    public InvalidBrowserNameError(String browserName){
       this.browserName=browserName;
    }

    @Override
    public String getMessage(){
        return "Invalid browser name: "+this.browserName;
    }
}
