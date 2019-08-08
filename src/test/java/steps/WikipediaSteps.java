package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.WikipediaPage;
import utilities.Config;
import utilities.Driver;

public class WikipediaSteps {

WikipediaPage wikipediaPage = new WikipediaPage();

    @Given("User is on Wikipedia Home Page")
    public void user_is_on_Wikipedia_Home_Page() {
        Driver.getDriver().get(Config.getProperty("wikipediaUrl"));

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
       wikipediaPage.Searchbox.sendKeys(string);
    }

    @Then("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
    wikipediaPage.SearchButton.click();
    }



    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();

        String expectedTitle = string + " - Wikipedia";

        Assert.assertTrue( actualTitle.equalsIgnoreCase(expectedTitle));
    }


    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String mainheader) {

String expectedHeader = mainheader;
String actualHeader = wikipediaPage.mainHeader.getText();

Assert.assertEquals(expectedHeader, actualHeader);

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String imageHeader) {


        String expectedImageHeader = imageHeader;
                String actualImageHEader = wikipediaPage.imageHeader.getText();

        Assert.assertEquals(expectedImageHeader,actualImageHEader);

    }

}


