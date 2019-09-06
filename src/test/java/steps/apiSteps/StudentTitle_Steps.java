package steps.apiSteps;

import apiModels.Student;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import utilities.APIRunner;

public class StudentTitle_Steps {

    @When("user hits list of  students API with {string}")
    public void user_hits_list_of_students_API_with(String uri) {
        APIRunner.runGET(uri);
    }

    @Then("user verifies each student's title to be at least two letters")
    public void user_verifies_each_student_s_title_to_be_at_least_two_letters() {
        int counter = 0;
        for (Student student: APIRunner.getCustomResponse().getStudents()) {
           String title = student.getCompany().getTitle();
            System.out.println(title);
            Assert.assertTrue("Student title is failing at index: " + counter + "",title.length()>1);
            counter++;
        }
    }

    @Then("user verifies each students email to be valid")
    public void user_verifies_each_students_email_to_be_valid() {
        int counter = 0;
        for (Student student : APIRunner.getCustomResponse().getStudents()) {
            String email = student.getContact().getEmailAddress();
            System.out.println(email);
            Assert.assertTrue("Student email is failing at index: " + counter, email.contains("@") && email.contains("."));
            counter++;
        }
    }

    }



