package com.barkoczi.peter.soccerleaguemanagertest.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequestTest {

    @Test
    @DisplayName("Get location list endpoint test")
    public void getLocationsEndPointTest() {
        int statusCode = given().when().get("http://localhost:8080/location/list").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get cup list endpoint test")
    public void getCupsEndPointTest() {
        int statusCode = given().when().get("http://localhost:8080/cups/list?locationId=1").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get cup's matches list endpoint test")
    public void getCupMatchesEndPointTest() {
        int statusCode = given().when().get("http://localhost:8080/cups/get_matches?cupId=101").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get team list endpoint test")
    public void getTeamsEndPointTest() {
        RestAssured.baseURI = "http://localhost:8080/teams";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.request(Method.GET, "?id=328");
        System.out.println(response.asString());
        int statusCode = response.getStatusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get cup's qualifiers endpoint test")
    public void getCupQualifiersTest() {
        int statusCode = given().when().get("http://localhost:8080/match/get_matches?cupId=839&matchType=qualifier").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get cup's semi finals endpoint test")
    public void getCupSemiFinalsTest() {
        int statusCode = given().when().get("http://localhost:8080/match/get_matches?cupId=839&matchType=semiFinal").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

    @Test
    @DisplayName("Get cup's semi finals endpoint test")
    public void getCupFinalsTest() {
        int statusCode = given().when().get("http://localhost:8080/match/get_matches?cupId=839&matchType=final").statusCode();
        assertTrue(String.valueOf(statusCode).startsWith("2"));
    }

}
