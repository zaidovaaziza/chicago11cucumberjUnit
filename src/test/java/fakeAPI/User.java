package fakeAPI;

public class User {

    String name;
    String userName;
    int age;
    String address;
    String password;

    public void info(){
        System.out.println("Name: " + this.name);
        System.out.println("Username: " + this.userName);
        System.out.println("age: " + age);
        System.out.println("Address: " + this.address);
        System.out.println("Password: " + this.password);
    }


}
