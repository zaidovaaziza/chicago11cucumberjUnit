package apiTest;

import apiModels.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class PojoTest {

    @Test
    public void testPojo() throws Exception{
        Instructor in = new Instructor();
        in.setBatch(11);
        in.setFirstName("Nina");
        in.setLastName("Dobrev");
        in.setId(1);
        in.setSubject("Theater");


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(in);
        System.out.println(json);

        Instructor instr2 = mapper.readValue(json,Instructor.class);
        System.out.println(instr2.getFirstName());

    }

}
