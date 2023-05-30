package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class UserAssertionTest extends TestBase {


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

    //Verify the if the total record is 20
    @Test
    public void Test01() {
        response.body("id.size()",equalTo(20));

    }
    //Verify the if the name of id = 2272662,is equal to ”Rev. Siddarth Ganaka”
    @Test
    public void Test02(){
        response.body("[2].name",equalTo("Rev. Siddarth Ganaka"));
    }
    //Check the single ‘Name’ in the Array list (Baala Chaturvedi)
    @Test
    public void Test03(){
        response.body("[8].name",equalTo("Baala Chaturvedi"));
    }
    //Check the multiple ‘Names’ in the ArrayList (Tanushree Devar Jr., Mahesh Kocchar, Gouranga Iyer)
  @Test
    public void Test04(){
      response
              .body("[10].name",equalTo("Tanushree Devar Jr."))
              .body("[5].name",equalTo("Mahesh Kocchar"))
              .body("[4].name",equalTo("Gouranga Iyer"));
    }
    //Verify the email of userid = 2272663 is equal “rajan_mahajan@koelpin.test
    @Test
    public void Test05(){
        response.body("findAll{it.id == 2272531}.email",hasItem("abbott_pushti@schroeder.test"));
    }
    //Verify the status is “Active” of user name is “Bhargava Mehrotra”
   @Test
    public void Test06(){
         response.body("[16].status",equalTo("inactive"));
   }
   //Verify the Gender = male of user name is “Ameyatma Bhat”
   @Test
    public void Test07(){
        response.body("[12].gender",equalTo("male"));

   }
}


