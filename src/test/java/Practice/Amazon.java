package Practice;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

public class Amazon {



    @Test

    public  void amazon() throws InterruptedException{

        Driver.getDriver().get("https://www.amazon.com/ref=nav_logo");
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone" + Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.id("add-to-cart-button")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.dismiss();
        Driver.getDriver().findElement(By.xpath("//button[@class=' a-button-close a-declarative']")).click();
    }
}
