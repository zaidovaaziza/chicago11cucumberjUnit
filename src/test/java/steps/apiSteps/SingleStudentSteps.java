package steps.apiSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utilities.APIRunner;

public class SingleStudentSteps {

    @When("user hits single student API with {string}")
    public void user_hits_single_student_API_with(String uri) {

        APIRunner.runGET(uri);
    }

    @Then("user checks for required attributes")
    public void user_checks_for_required_attributes() {
        System.out.println(APIRunner.getCustomResponse().getFirstName());
        System.out.println(APIRunner.getCustomResponse().getLastName());
        Assert.assertTrue("Student firstname is missing ",APIRunner.getCustomResponse().getFirstName()!=null);
        Assert.assertTrue("Student lastname is missing ",APIRunner.getCustomResponse().getLastName()!=null);
        Assert.assertTrue("Student email is missing ",APIRunner.getCustomResponse().getContact().getEmailAddress()!=null);
        Assert.assertTrue("Student address is missing ",APIRunner.getCustomResponse().getCompany().getAddress()!=null);
    }

}
