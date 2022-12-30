import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestDelete {
    @Test
    public void testDelete1() {
        when().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
