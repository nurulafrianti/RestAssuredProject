import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPut {

    @Test
    public void testPut1() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nurul");
        jsonObject.put("job", "SEIT");

        System.out.println("JSONObject to JSONString PUT: " +jsonObject.toJSONString());
        System.out.println("JSONObject PUT: " +jsonObject);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();
    }
}
