package FakeRestApi;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class FakeRestApiPatch {
    @Test
    public void testFakeRestApiPatch() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("lastName", "Malik Patch Test");

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
        when().
                patch("/users/4").
        then().
                statusCode(200).
                log().all();
    }
}
