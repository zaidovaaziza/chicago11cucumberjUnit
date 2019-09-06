package fakeAPI;

import java.util.List;

public class API {

    //user creation API
    //we use HTTP POST method to achieve this
    //Requirements
    //1. url+resource 2. request body
    //Imagine url+resource for this API is "api.test.com/user/create"
    //request body must be as following:
    //user must have name, user must have username
    //user must have password

    public static String createUser(String url, User user){
        String expectedURL  = "api.test.com/user/create";
        if(!url.equals(expectedURL)){
            return "404 - Resource Not Found";
        }

        if(user.name == null || user.userName == null || user.password == null){
            return "400 - Bad request";
        }

        DB.getUsers("hello321").add(user);
        return "201 - User Created";
    }

    /*
    API 2;
    GET HTTP method
    resource: /user/all
     */
    public static List<User> getUsers(String url){
        String expectedURL = "api.test.com/user/all";
        if(!url.equals(expectedURL)){
            System.out.println("404 - Resource Not Found");
            return null;
        }
        System.out.println("200 - OK");
        return DB.getUsers("hello321");
    }
}
