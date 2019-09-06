package test;

import apiModels.Teacher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

public class MappingClass {

    @Test
    public void JsonToObject(){

    }

    @Test
    public void deleteMethod(){
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/delete/83");

        System.out.println("Status " + response.statusCode());
    }

    @Test
    public void deleteStudentWthHeader(){
        Response response = RestAssured.given().header("Accept-Language", "en-US").
                header("Content-Type", "application/json").
                delete("http://cybertekchicago.com/student/delete/1445");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void postMethod(){
        Teacher teacher = new Teacher();
        teacher.setFirstName("Alla");
        teacher.setLastName("Popova");
        teacher.setGender("Female");
        teacher.setEmailAddress("allap@gmail.com");
        teacher.setDepartment("ESL");
        teacher.setBatch(15);
        teacher.setBirthDate("07/07/1965");
        teacher.setJoinDate("12/12/2019");
        teacher.setPassword("12345");
        teacher.setPhone("7742294503");
        teacher.setPremanentAddress("123 Main street");
        teacher.setSalary(100000);
        teacher.setSection("ABC");
        teacher.setSubject("Intermediate level");

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(teacher).when().post("http://api.cybertektraining.com/teacher/create");
        System.out.println("Status code: " + response.statusCode());
        System.out.println(response.asString());

    }

    @Test
    public void updateMethod(){

        Teacher teacher = new Teacher();
        teacher.setTeacherId(9);
        teacher.setFirstName("Alla");
        teacher.setLastName("Yurchenko");
        teacher.setGender("Male");
        teacher.setEmailAddress("rashidabd@gmail.com");
        teacher.setDepartment("ESL");
        teacher.setBatch(15);
        teacher.setBirthDate("07/07/1965");
        teacher.setJoinDate("12/12/2019");
        teacher.setPassword("12345");
        teacher.setPhone("7742294503");
        teacher.setPremanentAddress("123 Main street");
        teacher.setSalary(100000);
        teacher.setSection("ABC");
        teacher.setSubject("Intermediate level");


        Response r = RestAssured.given().contentType(ContentType.JSON).
                body(teacher).when().put("http://api.cybertektraining.com/teacher/update");
        System.out.println("Status code: " + r.statusCode());
        System.out.println(r.asString());

        Response r1 = RestAssured.given().auth().basic("username","password").
                when().contentType(ContentType.JSON).body("SomeObjectBody").post("url");

    }
}
