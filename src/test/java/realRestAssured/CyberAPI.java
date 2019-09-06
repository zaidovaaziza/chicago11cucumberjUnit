package realRestAssured;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

import java.io.IOException;

public class CyberAPI {

    @Test
    public void getTeachersTest() throws IOException {
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        //challenge: read 4 attributes from response and for each and every object
        //Jsonpath writing syntax of the path to preferred attribute in the response. This design is not preferred
        //Bc it will be hardcoded and dependent from the object structure.
        //we are going to use POJO model
        //POJO approach is most fit for API automation
        //IDEA: converting the JS
        // ON response into Basic Java object and have an access to it's fields/attributes/properties
        //we also use Jackson library to map from json to object or from object to json

        ObjectMapper mapper = new ObjectMapper();
        GeneralResponse gr = mapper.readValue(response.asString(),GeneralResponse.class);
        System.out.println(gr.getTeachers().size());

        for (GeneralTeacher teacher: gr.getTeachers()) {
            System.out.println(teacher.getFirstName() + "/n");
            Assert.assertTrue(teacher.getFirstName() !=null);
            Assert.assertTrue(teacher.getLastName() != null);
            Assert.assertTrue(teacher.getEmailAddress() != null);
            Assert.assertTrue(teacher.getSubject() != null);
        }

    }

    @Test
    public void createInstructor(){

    GeneralTeacher teacher = new GeneralTeacher();

        teacher.setBatch(11);
        teacher.setBirthDate("05/12/1999");
        teacher.setDepartment("Science");
        teacher.setEmailAddress("some@gmail.com");
        teacher.setGender("Female");
        teacher.setLastName("Smith");
        teacher.setFirstName("Ann");
        teacher.setPhone("687948376");
        teacher.setSubject("BIO11");
        teacher.setPremanentAddress("1912 Avenue U, Brooklyn, NY 11229");
       teacher.setJoinDate("06/23/18");
       teacher.setSalary(100000);
       teacher.setSection("abc");

       teacher.setPassword("apple123");


        String url = "http://api.cybertektraining.com/teacher/create";
        Response response = RestAssured.given().contentType(ContentType.JSON).body(teacher).when().post(url);
        System.out.println(response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    public void t2(){
        APIRunner.runGET("http://api.cybertektraining.com/teacher/all");
        System.out.println(APIRunner.getCustomResponse().getTeachers());
    }
}
