package tests.UpDateProfile;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;
import static tests.UpDateProfile.UpdateProfileTest.updateProfileRequest;

public class VerifyUpdatedProfileTest extends BaseTest
{

    @Test(dependsOnMethods = "updateProfile")
    public void VerifyUpdatedProfile()
    {

        // Ensure the token is not null
        Assert.assertNotNull(token, "Token is null. Login test must run first.");

        // Send GET request to fetch the updated profile
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/profile")
                .then()
                .statusCode(200)
                .extract().response();

        // Extract response data
        String actualName = response.jsonPath().getString("name");
        String actualDOB = response.jsonPath().getString("age");
        int actualGender = response.jsonPath().getInt("gender");

        // Validate the fields with expected values from the UpdateProfileTest class
        Assert.assertEquals(actualName, updateProfileRequest.getName(), "Name does not match!");
        Assert.assertEquals(actualDOB, updateProfileRequest.getDob(), "Date of birth does not match!");
        Assert.assertEquals(actualGender, updateProfileRequest.getGender(), "Gender does not match!");

        System.out.println("Profile verification successful.");
        System.out.println("Medical File Updated Successfully: " + response.asPrettyString());

    }
}
