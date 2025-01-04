package tests.Medical;


import io.restassured.response.Response;
import Models.UpdateMedicalFileRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class UpdateMedicalFileTest extends BaseTest
{

    // Instantiate the model with updated data
    public static final UpdateMedicalFileRequest updateMedicalFileRequest =
            new UpdateMedicalFileRequest(169, 58, "Diabetes", "Appendectomy",
            "Heart disease", "O+", "Peanuts",
            "Patient needs regular check-ups", "2004-05-15");

    @Test(priority = 1, dependsOnMethods = "login")
    public void updateMedicalFile()
    {

        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        // Send the API request using the model
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(updateMedicalFileRequest)
                .when()
                .post(baseUrl + "/api/medical-file")
                .then()
                .log().all()
                .extract()
                .response();

        // Assert response status code
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200, but got " + response.getStatusCode());

        // Validate response message or fields if applicable
        String successMessage = response.jsonPath().getString("message");
        System.out.println("Medical file updated successfully: " + response.asPrettyString());
    }
}
