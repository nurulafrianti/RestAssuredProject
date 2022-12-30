import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class FakeRestApiPut {

    @Test
    public void testFakeRestApiPut() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", "Taylor Put Test");
        jsonObject.put("lastName", "Swift Put Test");
        jsonObject.put("subjectId", 1);

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
        when().
                put("/users/4").
        then().
                statusCode(200).
                log().all();
    }
}
