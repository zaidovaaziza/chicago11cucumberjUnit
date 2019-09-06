package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import pages.BriteErpPage;
import utilities.Driver;

public class BriteErpSteps {
    BriteErpPage briteErpPage = new BriteErpPage();

    @Given("User is on  Brite Erp page")
    public void user_is_on_Brite_Erp_page() {

        Driver.getDriver().get("http://54.148.96.210/web/login");
        briteErpPage.emailButton.sendKeys("in@info.com" + Keys.ENTER);
        briteErpPage.passwordButton.sendKeys("alsfuh7we67" + Keys.ENTER);
    }

    @When("User clicks on Inventory button")
    public void user_clicks_on_Inventory_button() {
       briteErpPage.inventoryTab.click();
    }

    @Then("User clicks on Transfers button")
    public void user_clicks_on_Transfers_button() {
        briteErpPage.transfersTab.click();
    }

    @Then("User clicks on Import button")
    public void user_clicks_on_Import_button() {
        briteErpPage.importTab.click();
    }

    @Then("User clicks on Cancel button")
    public void user_clicks_on_Cancel_button() {
       briteErpPage.cancelButton.click();
    }





}
