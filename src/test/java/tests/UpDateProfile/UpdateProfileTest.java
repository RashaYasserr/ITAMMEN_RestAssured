package tests.UpDateProfile;

import Models.UpdateProfileRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class UpdateProfileTest extends BaseTest
{


    // Initialize the UpdateProfileRequest object with data
    public static UpdateProfileRequest updateProfileRequest =
            new UpdateProfileRequest("rasha", "1998-03-03", 1);

    @Test(dependsOnMethods = "login")
    public void updateProfile()
    {
        Assert.assertNotNull(token, "Token is null. Login test must run first.");

        // Use the UpdateProfileRequest object to pass data in the API request
        given()
                .header("Authorization", "Bearer " + token)
                .contentType("multipart/form-data")
                .multiPart("name", updateProfileRequest.getName())
                .multiPart("dob", updateProfileRequest.getDob())
                .multiPart("gender", updateProfileRequest.getGender())
                .when()
                .post(baseUrl+"/api/profile/update")
                .then()
                .statusCode(200);

        System.out.println("Profile updated successfully.");
    }
}
