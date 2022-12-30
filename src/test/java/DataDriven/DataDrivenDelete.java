package DataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenDelete {

    @DataProvider (name = "DeleteData")
    public Object[] dataForDelete() {
        return new Object[] {
                9,10
        };
    }

    @Test(dataProvider = "DeleteData")
    public void testDataDrivenDelete(Object userId) {
        baseURI = "http://localhost:3000/";
        when().
                delete("/users/" + userId).
                then().
                statusCode(200).
                log().all();
    }
}
