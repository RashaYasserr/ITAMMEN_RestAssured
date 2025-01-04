package tests.Diagnosis;



import io.restassured.response.Response;
import Models.DiagnosticRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SubmitDiagnosticTest extends BaseTest
{

    public static int extractedId = 0;

    @Test(priority = 2, dependsOnMethods = "login")
    public void submitDiagnostic() {

        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        // Prepare the request body using the model
        DiagnosticRequest requestBody = new DiagnosticRequest(List.of(
                new DiagnosticRequest.QuestionAnswer(1, "Headache"),
                new DiagnosticRequest.QuestionAnswer(2, "Since a day or two"),
                new DiagnosticRequest.QuestionAnswer(3, "Stayed the same"),
                new DiagnosticRequest.QuestionAnswer(4, "Entire body"),
                new DiagnosticRequest.QuestionAnswer(5, "This is the first time I've experienced these symptoms")));

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/api/diagnostic/submit?language=en")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        extractedId = response.path("id");
        Assert.assertTrue(extractedId > 0, "Response ID should be greater than 0.");

        Assert.assertEquals(response.statusCode(), 200, "Expected status code 200.");
        Assert.assertNotNull(response.path("details"), "Details should not be null.");

        System.out.println("Extracted ID from response: " + extractedId);
    }
}
