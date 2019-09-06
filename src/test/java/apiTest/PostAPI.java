package apiTest;

import apiModels.CustomResponse;
import apiModels.Instructor;
import apiModels.Student;
import apiModels.Teacher;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utilities.APIRunner;

import java.io.IOException;

public class PostAPI {

    @Test
    public void postInstructor(){
        Instructor instructor = new Instructor();
        instructor.setLastName("Doe");
        instructor.setFirstName("New John");
        instructor.setSubject("Advance MACHINE LEARNING");
        instructor.setBatch(11);

      //  Response response = RestAssured.given().contentType(ContentType.JSON).body(instructor).when().post("http://api.cybertektraining.com/teacher/create");
        Response response = RestAssured.given().contentType(ContentType.JSON).body(instructor).when().post("http://cybertekchicago.com/instructor/create");

        System.out.println(response.statusCode());


    }

    @Test
    public void customSingleStudent() throws IOException {
        Response response = RestAssured.get("http://cybertekchicago.com/student/1510");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(),CustomResponse.class);
        System.out.println(cr.getFirstName());
        System.out.println(cr.getContact().getEmailAddress());
    }

    @Test
    public void listOfInstructors() throws IOException {
        Response response = RestAssured.get("http://api.cybertektraining.com/teacher/all");
        System.out.println(response.statusCode());
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(),CustomResponse.class);
        System.out.println( cr.getTeachers().get(0).getSubject());

        for (Teacher teacher: cr.getTeachers()) {
            if(teacher.getSubject()==null){
                System.out.println("FirstName " + teacher.getFirstName()+ "LastName " + teacher.getLastName());
            }
        }
    }

    @Test
    public void studentLocation() throws IOException {
    Response response = RestAssured.get("http://cybertekchicago.com/student/all");
        ObjectMapper mapper = new ObjectMapper();
        CustomResponse cr = mapper.readValue(response.asString(),CustomResponse.class);
        System.out.println(cr.getStudents().size());
        int count = 0;

        for (Student student:cr.getStudents()) {
            if(student.getCompany().getAddress().getCity().equalsIgnoreCase("Chicago")){
                System.out.println(student.getFirstName());
                count++;
            }
        }
        System.out.println("Total: " + count);
    }

    @Test
    public void utilTest(){
        APIRunner.runGET("http://api.cybertektraining.com/student/57423/");
        String companyLocation = APIRunner.getCustomResponse().getCompany().getAddress().getCity();
        System.out.println(companyLocation);
    }

    @Test
    public void bacth11(){
        APIRunner.runGET("http://cybertekchicago.com/student/all");
        int counter = 0;
        for (Student student: APIRunner.getCustomResponse().getStudents()) {
            if(student.getBatch()==11){
                System.out.println(student.getFirstName());
                counter++;

            }
        }
        System.out.println("Total batch 11 students: " + counter);
    }
}
