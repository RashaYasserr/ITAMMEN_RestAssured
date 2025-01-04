package tests.Medical;



import io.restassured.response.Response;
import  Models.UpdateMedicalFileRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;
import static tests.Medical.UpdateMedicalFileTest.updateMedicalFileRequest;

public class VerifyUpdatedMedicalFileTest extends BaseTest
{

    @Test(priority = 2, dependsOnMethods = "updateMedicalFile")
    public void verifyUpdatedMedicalFile() {

        // Ensure token is available
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        // Send a GET request to retrieve the updated medical file
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl + "/api/medical-file")
                .then()
                .statusCode(200)
                .extract().response();


        // Extract fields from the response
        double actualHeight = response.jsonPath().getDouble("height");
        double actualWeight = response.jsonPath().getDouble("weight");
        String actualLongTermDiseases = response.jsonPath().getString("long_term_diseases");
        String actualPreviousSurgeries = response.jsonPath().getString("previous_surgeries");
        String actualFamilyMedicalHistory = response.jsonPath().getString("family_medical_history");
        String actualBloodType = response.jsonPath().getString("blood_type");
        String actualAllergies = response.jsonPath().getString("allergies");
        String actualMedicalNotes = response.jsonPath().getString("medical_notes");
        String actualDob = response.jsonPath().getString("dob");

        // Validate the fields using the model values
        Assert.assertEquals(actualHeight, updateMedicalFileRequest.getHeight(), "Height does not match!");
        Assert.assertEquals(actualWeight, updateMedicalFileRequest.getWeight(), "Weight does not match!");
        Assert.assertEquals(actualLongTermDiseases, updateMedicalFileRequest.getLongTermDiseases(), "Long term diseases do not match!");
        Assert.assertEquals(actualPreviousSurgeries, updateMedicalFileRequest.getPreviousSurgeries(), "Previous surgeries do not match!");
        Assert.assertEquals(actualFamilyMedicalHistory, updateMedicalFileRequest.getFamilyMedicalHistory(), "Family medical history does not match!");
        Assert.assertEquals(actualBloodType, updateMedicalFileRequest.getBloodType(), "Blood type does not match!");
        Assert.assertEquals(actualAllergies, updateMedicalFileRequest.getAllergies(), "Allergies do not match!");
        Assert.assertEquals(actualMedicalNotes, updateMedicalFileRequest.getMedicalNotes(), "Medical notes do not match!");
        Assert.assertEquals(actualDob, updateMedicalFileRequest.getDob(), "Date of birth does not match!");


        System.out.println("Profile verification successful." + response.asPrettyString());
    }
}
