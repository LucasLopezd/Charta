package com.wallet.wallet.rest;

import io.restassured.response.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

public class test {
    String url = "https://localhost:8081/categories/all";
    Response response = get(url);

    @Test
    public void test_1(){
        System.out.println(response.getBody().asString());
    }
}
