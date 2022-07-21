package context;


import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.Header;
import org.json.JSONObject;

import java.util.HashMap;

public class RestAssuredMethods {

    public void pocRestAssured(){
        HashMap <String,String> head = new HashMap<String,String>();

        RestAssured.baseURI="";

        RequestSpecification request = null;

        request.body(new HashMap<String,String>());
        request.contentType("").headers(head);
        Response response;
        JSONObject obj = null;
        obj.put("","");






    }
}
