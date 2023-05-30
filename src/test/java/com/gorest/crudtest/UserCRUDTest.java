package com.gorest.crudtest;

import com.gorest.model.PostsPojo;
import com.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest {
    static int userId;

    @Test
    public void test001() {
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setName("Pinal");
        postsPojo.setEmail("Pinalpatel123@gmail.com");
        postsPojo.setGender("Female");
        postsPojo.setStatus("Active");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(postsPojo)
                .post();
        response.then().log().all().statusCode(201);
    }

    @Test
    public void test002() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Pinal1");
        userPojo.setEmail("Pinalpatel@gmail.com");
        userPojo.setStatus("Inactive");
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(userPojo)
                .put();
        response.then().log().all().statusCode(200);
    }

    @Test
    public void test003() {
        given()
                .pathParam("id", userId)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(204);

        given()
                .pathParam("id", userId)
                .when()
                .get("/{id}")
                .then().statusCode(404);
    }
}
