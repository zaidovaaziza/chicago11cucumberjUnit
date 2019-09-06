package apiModels;

import bootcampAPI.BootcampResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InstructorsList {

    @Test
    public void studList(){
        Response r = RestAssured.get("http://cybertekchicago.com/student/all");
        System.out.println(r.statusCode());
        Assert.assertEquals(200,r.statusCode());
        String json = r.asString();
        System.out.println(json);

        JsonPath path = r.jsonPath();

        String name = path.get(".student[0].firstName");
        System.out.println(name);
    }

    @Test
    public void pojoInstructors() throws IOException {
        Response r = RestAssured.get("http://api.cybertektraining.com/teacher/all");
        System.out.println(r.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        BootcampResponse response = mapper.readValue(r.asString(), BootcampResponse.class);
        int size = response.getTeachers().size();
        System.out.println(size);


    }

}
