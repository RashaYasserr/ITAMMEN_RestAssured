package tests.UpDateProfile;

import Utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



import static org.hamcrest.Matchers.*;

public class ShowProfileDataTest extends BaseTest
{
    @Test(dependsOnMethods = "login")
    public void ShowProfileData()
    {
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/profile")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body("status", notNullValue())
                .body("created_at", notNullValue())
                .log().all();
    }
}


