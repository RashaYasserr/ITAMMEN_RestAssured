package tests.Diagnosis;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static tests.Diagnosis.SubmitDiagnosticTest.extractedId;

public class MyDiagnosticHistoryTest extends BaseTest {

    @Test(priority = 2, dependsOnMethods = "login")
    public void getHistory() {
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/diagnostic")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        List<Map<String, Object>> items = response.jsonPath().getList("items");
        boolean idExists = false;

         idExists = items.stream().anyMatch(item -> item.get("id").equals(extractedId));

//        for (Map<String, Object> item : items) {
//            if (item.get("id").equals(extractedId)) {
//                idExists = true;
//                break;
//            }
//        }

        Assert.assertTrue(idExists, "The response does not contain the expected id.");
        System.out.println("Diagnostic History: " + items);
    }
}



