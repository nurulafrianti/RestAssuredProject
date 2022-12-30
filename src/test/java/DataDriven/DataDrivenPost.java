package DataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class DataDrivenPost extends DataForTest {

    @DataProvider (name = "DataForPost")
    public Object[][] dataForPost() {
//        Object[][] data = new Object[2][3];
//        data[0][0] = "Raffi";
//        data[0][1] = "Ahmad";
//        data[0][2] = 2;

//        data[1][0] = "Nagita";
//        data[1][1] = "Slavina";
//        data[1][2] = 1;

//        return data;

        return new Object[][] {
                {"Rafathar", "Malik", 1},
                {"Rayyanza", "Malik", 2},
        };
    }

    @Parameters("userId")
    @Test(dataProvider = "DataForPost")
    public void testDataDrivenPost(String firstName, String lastName, int subjectId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(jsonObject.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }
}
