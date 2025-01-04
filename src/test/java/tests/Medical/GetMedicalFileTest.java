package tests.Medical;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class GetMedicalFileTest extends BaseTest
{

    @Test(priority = 1, dependsOnMethods = "login")
    public void getMedicalFile() {

        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .when()
                .get(baseUrl + "/api/medical-file")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        Assert.assertNotNull(response, "Response is null.");

        // Check that keys exist in the response (no need to check values)
        Assert.assertNotNull(response.jsonPath().get("created_at"), "Key 'created_at' is missing.");
        Assert.assertNotNull(response.jsonPath().get("height"), "Key 'height' is missing.");
        Assert.assertNotNull(response.jsonPath().get("weight"), "Key 'weight' is missing.");
        Assert.assertNotNull(response.jsonPath().get("long_term_diseases"), "Key 'long_term_diseases' is missing.");
        Assert.assertNotNull(response.jsonPath().get("previous_surgeries"), "Key 'previous_surgeries' is missing.");
        Assert.assertNotNull(response.jsonPath().get("family_medical_history"), "Key 'family_medical_history' is missing.");
        Assert.assertNotNull(response.jsonPath().get("blood_type"), "Key 'blood_type' is missing.");
        Assert.assertNotNull(response.jsonPath().get("allergies"), "Key 'allergies' is missing.");
        Assert.assertNotNull(response.jsonPath().get("medical_notes"), "Key 'medical_notes' is missing.");
        Assert.assertNotNull(response.jsonPath().get("dob"), "Key 'dob' is missing.");
        Assert.assertNotNull(response.jsonPath().get("doctor"), "Key 'doctor' is missing.");

        System.out.println("Medical File Response: " + response.asPrettyString());
    }
}
