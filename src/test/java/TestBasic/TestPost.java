package TestBasic;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class TestPost {

    @Test
    public void testPost() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Nurul");
        map.put("job", "SEIT");
        System.out.println("Map: " +map);
        JSONObject jsonObjectUsingMap = new JSONObject(map);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Nurul");
        jsonObject.put("job", "SEIT");

        System.out.println("JSONObject using Map: " +jsonObjectUsingMap);
        System.out.println("JSONObject to JSONString POST: " +jsonObject.toJSONString());
        System.out.println("JSONObject without Map POST: " +jsonObject);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);

    }
}
