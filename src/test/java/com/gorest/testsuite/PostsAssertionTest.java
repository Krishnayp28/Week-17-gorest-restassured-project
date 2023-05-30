package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest {


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
    //Verify the if the total record is 25
    @Test
    public void Test01(){
        response.body("id.size()",equalTo(25));
    }
    //Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demittocentum.”

    @Test
    public void Test02() {
        response.body("findAll{it.id == 39686}.title", hasItem("Ustilo quasi aveho quos caveo charisma."));
    }

    //Check the single user_id in the Array list (5522)
    @Test
    public void Test03() {
        response.body("findAll{it}.id", hasItem( 39663));
    }


    // Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void Test04(){
        response.body("findAll{it}.id", hasItems(39662, 39655, 39654));
    }

    // Verify the body of userid = 2678 is equal “Carus eaque voluptatem.
    @Test
    public void Test05(){
        response.body("findAll{it.id == 39304}.body", hasItem("Argumentum adultus virga. Aequus vinculum abbas. Alveus spero aurum. Aptus dolorem depono. Fugiat voluptate suspendo. Ustilo alii vinco. Spargo cruciamentum mollitia. Deprimo depulso sunt. Cribro quas desino. Autem vitae atavus. Perspiciatis tot decumbo. Vigilo congregatio turba. Crepusculum vacuus solvo. Corrigo desolo tempora."));
    }
}


