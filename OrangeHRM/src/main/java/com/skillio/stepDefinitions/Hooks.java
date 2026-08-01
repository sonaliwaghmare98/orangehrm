package com.skillio.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import static com.skillio.base.Keyword.*;

public final class Hooks {
   // public Keyword keyword=new Keyword();

   // @Before
    public void setUp(){
       openBrowser("chrome");
       launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
   // @After
    public void tearDown(){
        closeBrowser();
    }
}
