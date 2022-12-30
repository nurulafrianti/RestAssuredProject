import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class FakeRestApiDelete {

    @Test
    public void testFakeRestApiPut() {
        baseURI = "http://localhost:3000/";
        when().
                delete("/users/4").
        then().
                statusCode(200).
                log().all();
    }
}
