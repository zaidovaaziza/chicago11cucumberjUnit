package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

   // @Before(value = "@amazon" , order =1)
    @Before
    public void setUp(){
        System.out.println("This is hooks setup method");


    }

   // @Before(value = "google")
    public void setUp2(){
        System.out.println("THis is hooks for google");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Hooks clean up");
        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        }
    }
}
