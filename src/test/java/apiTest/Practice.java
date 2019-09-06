package apiTest;

import org.junit.Test;
import utilities.APIRunner;

public class Practice {

    @Test
    public void oneTeacher(){

        APIRunner.runGET("http://api.cybertektraining.com/teacher/9");
               System.out.println("FirstName: " + APIRunner.getCustomResponse().getTeachers().get(0).getFirstName());
        System.out.println("LastName: " + APIRunner.getCustomResponse().getTeachers().get(0).getLastName());


    }
}
