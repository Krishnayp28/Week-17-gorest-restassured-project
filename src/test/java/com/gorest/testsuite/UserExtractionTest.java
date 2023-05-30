package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest  {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {


        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users?page=1&per_page=20").
                then().statusCode(200);
    }

    //Extract All Ids
    @Test
    public void test001() {
        List<Integer> listOfIds =  response.extract().path("id");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println("List of Ids are : " + listOfIds);
            System.out.println("------------------End of Test---------------------------");

        }
        //Extract All Name
    @Test
    public void Test02() {
        List<String> listOfName = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Name are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract All Name of 5th object
    @Test
    public void Test03() {
        String listOfName = response.extract().path("[3].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Name are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the names of all object whose status = inactive
    @Test
    public void Test04() {
        List<String> listOfName = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Name are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the gender of all the object whose status = active
    @Test
    public void Test05() {
        List<String> listOfName = response.extract().path("findAll{it.status == 'active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Name are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");
    }
    //Print the names of the object whose gender = female
    @Test
    public void Test06() {
        List<String> listOfName = response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Name are : " + listOfName);
        System.out.println("------------------End of Test---------------------------");
    }
    //Get all the emails of the object where status = inactive
    @Test
    public void Test07() {
        List<String> listOfEmail = response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Email are : " + listOfEmail);
        System.out.println("------------------End of Test---------------------------");

    }
    //Get the ids of the object where gender = male
    @Test
    public void Test08() {
        List<Integer> listOfId = response.extract().path("findAll{it.gender == 'male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Id are : " + listOfId);
        System.out.println("------------------End of Test---------------------------");
    }
    //Get all the status
    @Test
    public void Test09() {
        List<String> listOfStatus = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of status  are : " + listOfStatus);
        System.out.println("------------------End of Test---------------------------");
    }
    // Get email of the object where name = Rajan Mahajan
    @Test
    public void Test010() {
        String email = response.extract().path("[5].email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of email are : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    // Get gender of id = 2272658,
    @Test
    public void Test011() {
        String   gender = response.extract().path("[6].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Id are : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }

}
