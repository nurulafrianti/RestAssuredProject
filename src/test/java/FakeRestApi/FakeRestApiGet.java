package FakeRestApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FakeRestApiGet {

    @Test
    public void testFakeRestApiGet() {
        baseURI = "http://localhost:3000/";
        given().
                param("name", "Java").
                get("/subjects").
        then().
                statusCode(200).
                log().all();
    }
}
