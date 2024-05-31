package com.sauce.stepDefs;

import com.sauce.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before //Java
    public void setUp(){
      //  Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Before selenium 4
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// After selenium 4
        Driver.get().manage().window().maximize();
    }

    @After//Java
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}
