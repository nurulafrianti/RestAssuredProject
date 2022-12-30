import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestPatch {
    @Test
    public void testPatch() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nurul");
        jsonObject.put("job", "SEIT");

        System.out.println("JSONObject to JSONString PATCH: " +jsonObject.toJSONString());
        System.out.println("JSONObject PATCH: " +jsonObject);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                patch("https://reqres.in/api/users/2").
                then().
                statusCode(200).
                log().all();
    }
}
