package apiModels;

public class Person {

    private String firstName;
    private String lastName;
    private MyClass classes;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MyClass getClasses() {
        return classes;
    }

    public void setClasses(MyClass classes) {
        this.classes = classes;
    }
}
