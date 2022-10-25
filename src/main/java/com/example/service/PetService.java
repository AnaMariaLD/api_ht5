package com.example.service;

import com.example.service.uritemplate.UriTemplate;
import io.restassured.response.Response;

public class PetService extends CommonService {

    private static PetService instance;

    private PetService() {
    }

    public static PetService getInstance() {
        if (instance == null) instance = new PetService();
        return instance;
    }

    public Response postRequest(UriTemplate uri, Object body) {
        return super.postRequest(uri.getUri(), body);
    }

    public Response getRequestQuery(UriTemplate uri, String status) {
        return super.getRequestQuery(uri.getUri(), status);
    }

    public Response getRequest(UriTemplate uri) {
        return super.getRequest(uri.getUri());
    }

    public Response putRequest(UriTemplate uri, Object body) {
        return super.putRequest(uri.getUri(), body);
    }
}
