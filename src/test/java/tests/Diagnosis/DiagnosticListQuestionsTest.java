package tests.Diagnosis;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import Utils.BaseTest;


public class DiagnosticListQuestionsTest extends BaseTest
{

    @Test(priority = 1, dependsOnMethods = "login")
    public void verifyDiagnosticQuestions()
    {

        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(baseUrl+"/api/diagnostic/questions?language=en")
                .then()
                .statusCode(200)
                .extract().response();

        // (check if questions exist)
        int questionsSize = response.jsonPath().getList("").size();
        Assert.assertTrue(questionsSize > 0, "No questions found in the response!");

        // Check the first question
        String firstQuestion = response.jsonPath().getString("[0].question");
        Assert.assertEquals(firstQuestion, "Please select the symptoms you're experiencing?", "First question does not match!");

        // Check answers for the first question
        int answersSize = response.jsonPath().getList("[0].answers").size();
        Assert.assertTrue(answersSize > 0, "No answers found for the first question!");

        // Check the max number of answers in the validation for the first question
        int maxAnswers = response.jsonPath().getInt("[0].validation.max");
        Assert.assertEquals(maxAnswers, 10, "Max answers value does not match!");

        System.out.println("Diagnostic questions verified successfully.");
    }
}
