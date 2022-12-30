import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    void test1() {

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Test 1");
        System.out.println("Response String: " + response.asString());
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Response Header: " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void test2() {
        System.out.println("Test 2");
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
}
