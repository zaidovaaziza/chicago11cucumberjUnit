package apiTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

public class CMstudent {

    @Test
    public void studentList(){

        Response response = RestAssured.get("http://cybertekchicago.com/student/all");
        System.out.println(response.statusCode());
//        RestAssured.given().get("http://cybertekchicago.com/student/al").then().statusCode(200);
        System.out.println(response.asString());
        JsonPath jp = response.jsonPath();
//       int b = jp.get("batch");
      //  System.out.println(b);
        String fn = jp.get("firstName");
        System.out.println(fn);
        String email = jp.get("contact.emailAddress");
        System.out.println(email);
        String street = jp.get("company.address.street");
        System.out.println(street);
        List<String> title = jp.get("title");
        System.out.println(title.size());

    }
}
