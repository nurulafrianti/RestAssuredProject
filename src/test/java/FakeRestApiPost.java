import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class FakeRestApiPost {
    @Test
    public void testFakeRestApiPost() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Zayn");
        jsonObject.put("lastName", "Malik");
        jsonObject.put("subjectId", 1);

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();
    }
}
