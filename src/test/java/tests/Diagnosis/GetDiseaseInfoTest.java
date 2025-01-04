package tests.Diagnosis;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import Utils.BaseTest;


public class GetDiseaseInfoTest extends BaseTest
{
    @Test(priority = 2, dependsOnMethods = "login")
    public void GetDiseaseInfo()
    {
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        String diseaseSlug = "migraine";

        String url = baseUrl + "/api/diseases/" + diseaseSlug + "?language=en";

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log().all();
    }
}
