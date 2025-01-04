package tests.Authentication;

import Utils.BaseTest;
import io.restassured.response.Response;
import Models.LoginRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest
{

    @Test(priority = 1)
    public void login()
    {
        // Creating the login request model
        LoginRequest loginRequest = new LoginRequest("emailbuy2fixed@goeschman.com",
                "emailbuy2fixed@goeschman.com72", 1);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(loginRequest) // Send LoginRequest model
                .when()
                .post(baseUrl+"/api/auth/login") // Endpoint for login
                .then()
                .statusCode(200) // Validate response status code
                .extract().response(); // Extract the full response

        // Extract the access token from the response
        String token = response.jsonPath().getString("access_token");

        // Validate the token is not null
        Assert.assertNotNull(token, "Login failed! Access token is null.");

        // Store token in BaseTest for future use
        BaseTest.token = token;

        // Print token for debugging
        System.out.println("Access Token: " + token);
    }
}
