package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidApp {

    public static AndroidDriver androidDriver;
    public static AppiumDriverLocalService service;

    @Test
    public void testMobileApp() throws MalformedURLException{

        DesiredCapabilities capabilities;
        File app = new File(Config.getProperty("apk_file_path"));
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        capabilities = new DesiredCapabilities().chrome();

//        capabilities.setCapability("addPackage", "com.kehe.delivery.qa");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        capabilities.setCapability("chromedriverExecutable","/Users/Azika/Desktop/chicago11cucumberjUnit/src/test/java/drivers/chromedriver");

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"SamsungVD");
        capabilities.setCapability("avd","SamsungVD");
//        capabilities.setCapability(MobileCapabilityType.APP,"TBD");
        //automatically grant permissions
        capabilities.setCapability("autoGrantPermissions", true);
        //automatically accepts all the notifications
        capabilities.setCapability("autoAcceptAlerts",true);
        //wait for server
        capabilities.setCapability("newCommandTimeout",60000);

        WebDriver androidWebDriver = new AndroidDriver(new URL("http://127.0.01:4723/wd/hub"), capabilities);
        androidWebDriver.get("https://www.amazon.com");
        String actualTitle = androidWebDriver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

}
