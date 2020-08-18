package com.barkoczi.peter.soccerleaguemanagertest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequestTest {

    @Ignore
    @Test
    @DisplayName("Delete location test")
    public void deleteLocation() {
        String response = given().when().delete("http://localhost:8080/location/330").body().asString();

        System.out.println(response);
    }
}
