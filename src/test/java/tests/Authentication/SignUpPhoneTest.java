package tests.Authentication;

import io.restassured.response.Response;
import io.restassured.response.Response;
import Models.SignUpRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class SignUpPhoneTest extends BaseTest
{

    @Test(priority = 1)
    public void signUpWithPhone()
    {
        // Create a SignUpRequest object for phone
        SignUpRequest requestBody = new SignUpRequest(0, null,
                "01161377405");


        // Make the API request
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/api/auth/register")
                .then()
                .extract().response();

        // Assert the status code
        Assert.assertEquals(response.statusCode(), 200, "Sign up failed with phone!");
    }
}
