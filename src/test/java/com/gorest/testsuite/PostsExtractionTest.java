package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {


    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {


        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/posts?page=1&per_page=25").
                then().statusCode(200);
    }
    //1. Extract the title
    @Test
    public void test01() {
        System.out.println("The Title Of ID 39297 : " + response.extract().path("findAll{it.id == 39297 }.title"));
    }
   //. Extract the total number of record
    @Test
    public void test02() {
        System.out.println("The Total Number Of Records : " + response.extract().path("size()"));
    }
    //. Extract the body of 15th record
    @Test
    public void test03() {
        System.out.println("The Response Body Of Record Number 6 : " + response.extract().path("findAll{it.id}.body[5]"));
    }
  //Extract the user_id of all the records
    @Test
    public void test04() {
        System.out.println("The User IDs Of All Records : " + response.extract().path("findAll{it.id}.user_id"));
    }
    //Extract the title of all the records
    @Test
    public void test05() {
        System.out.println("All Titles From The Response Body : " + response.extract().path("findAll{it.id}.title"));
    }
    //Extract the body of all records whose id = 2671
    @Test
    public void test06() {
        System.out.println("All Titles From The Response Bdy "+ response.extract().path("findAll{it.id == 39297}.title"));
    }
    //Extract the body of all records whose id = 2671
    @Test
    public void test07() {
        System.out.println("The Response Body Of Record Having ID As 39296 : " + response.extract().path("findAll{it.id == 39296}.body"));
    }


}

