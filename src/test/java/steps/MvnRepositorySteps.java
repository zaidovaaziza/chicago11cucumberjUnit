package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class MvnRepositorySteps {

    @When("User is on Mvnrepository main page")
    public void user_is_on_Mvnrepository_main_page() {
        Driver.getDriver().get("https://mvnrepository.com/");
    }

    @Then("User searches for word {string}")
    public void user_searches_for_word(String word) {
        Driver.getDriver().findElement(By.id("query")).sendKeys("cucumber java" + Keys.ENTER);

    }

    @Then("User should see word \"cucumber java on the first result")
    public void user_should_see_word_cucumber_java_on_the_first_result() {
    WebElement result =  Driver.getDriver().findElement(By.xpath("//a[.=\"Cucumber JVM: Java\"][1]"));
       // Assert.assertTrue(result,word);
    }

}
