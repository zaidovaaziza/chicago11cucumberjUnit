package bootcampAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BootcampTeacher {

    private String firstName;
    private String lastName;
    private String subject;


}
