package test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseExample {

    public static void main(String[] args) {
        //url:         ec2-3-17-59-100.us-east-2.compute.amazonaws.com
        //username:      hr
        //password:      hr

          /*
        |first_name | last_name|
        |Ellen      | Abel     |
        |Sundar     | Ande     |
        |Mozhe      | Atkison  |
         */

        Map<String,Object> map1 = new HashMap<>();
        map1.put("first_name", "Ellen");
        map1.put("last_name","Abel");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("first_name", "Sundar");
        map2.put("last_name","Ande");

        Map<String,Object> map3 = new HashMap<>();
        map3.put("first_name", "Mozhe");
        map3.put("last_name","Akison");

        List<Map<String ,Object>> table = new ArrayList<>();

        table.add(map1);
        table.add(map2);
        table.add(map3);

       // for(Map)





        String oracleUrl = "jdbc:oracle:thin:@ec2-18-220-39-83.us-east-2.compute.amazonaws.com:1521:xe";
        String oracleUsername = "hr";
        String oraclePassword = "hr";



        try {

            Connection connect = DriverManager.getConnection(oracleUrl, oracleUsername, oraclePassword);
            Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet result = st.executeQuery("select first_name,last_name from employees");

            ResultSetMetaData metaData = result.getMetaData();

            int columnCount = metaData.getColumnCount();
            String columnName= metaData.getColumnName(1);

            System.out.println("Column count: " + columnCount);
            System.out.println("Column name: " + columnName);

            List<Map<String ,Object>> myTable = new ArrayList<>();

           while(result.next()) {

               Map<String,Object> map = new HashMap<>();

               for(int i = 1; i<=columnCount;i++){
                map.put(metaData.getColumnName(i),result.getObject(i));
                   System.out.println(metaData.getColumnName(i)+ " => " + result.getObject(i) + " ");
                 //  System.out.println(result.getObject(i) + " ");
               }

               myTable.add(map);

              // System.out.println("===============================");

              // System.out.println("FirstName: " + result.getObject(1) + "FirstName: " + result.getObject(2));
           }

//           System.out.println("First name: " + result.getObject(1));
//            result.next();
//            result.next();
//            result.next();
//            System.out.println("First name: " + result.getObject(2));
            for(Map<String ,Object> m: myTable){

                System.out.println(m.get("First_name ") + " => " + m.get("Last_name"));
            }

        } catch (SQLException e) {

            System.out.println("Failed to open connection!");

        }


    }

}