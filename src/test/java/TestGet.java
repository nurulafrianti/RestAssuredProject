import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestGet {

    @Test
    public void testGet() {
        given().
                header("Content-Type", "application/json").
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael", "Lindsay"));
    }
}
