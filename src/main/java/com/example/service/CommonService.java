package com.example.service;

import com.example.log.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class CommonService {
    private static final String BASE_URI = "https://petstore.swagger.io/v2/";
    private final Function<String, String> prepareUri = uri -> String.format("%s%s", BASE_URI, uri);
    protected RequestSpecification requestSpecification;

    public CommonService() {
        requestSpecification = RestAssured.given();
        setCommonParams();
    }

    protected void setCommonParams() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        requestSpecification.headers(headers);
    }

    protected Response postRequest(String uri, Object body) {
        Log.info("Sending the POST request to the URI " + prepareUri.apply(uri));
        Response response = requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().post(prepareUri.apply(uri));
        Log.info("Response body is " + response.asPrettyString());
        return response;
    }

    protected Response getRequestQuery(String uri, String status) {
        Log.info("Sending the GET with a query to the URI" + prepareUri.apply(uri));
        Response response = requestSpecification.queryParam("status", status).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("Response body is " + response.asPrettyString());
        return response;
    }

    protected Response getRequest(String uri) {
        Log.info("Sending the GET request to the URI" + prepareUri.apply(uri));
        Response response = requestSpecification.expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().get(prepareUri.apply(uri));
        Log.info("Response body is "+ response.asPrettyString());
        return response;
    }

    protected Response putRequest(String uri, Object body) {
        Log.info("Sending the PUT request to the URI" + prepareUri.apply(uri));
        Response response= requestSpecification.body(body).expect().statusCode(HttpStatus.SC_OK).log().ifError()
                .when().put(prepareUri.apply(uri));
        Log.info("Response body is "+ response.asPrettyString());
        return response;

    }

}
