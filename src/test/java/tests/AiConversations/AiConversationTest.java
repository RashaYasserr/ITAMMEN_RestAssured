package tests.AiConversations;

import io.restassured.response.Response;
import Models.UserMessageRequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class AiConversationTest extends BaseTest
{
    private static String latestAnswer;


    public static String getLatestAnswer()
    {
        return latestAnswer;
    }


    @Test(priority = 1, dependsOnMethods = "login")
    public void ASkQuestion()
    {
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        String disease = "headache";

        // Create a request model object
        UserMessageRequest requestBody = new UserMessageRequest(disease);

        // Send the request and get the response
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(baseUrl + "/api/conversation/ask-question");

        // Extract the 'answer' field from the response
        String answer = response.jsonPath().getString("answer");
        latestAnswer = response.jsonPath().getString("answer");

        // Assertions to verify the response
        Assert.assertEquals(response.getStatusCode(), 200, "Unexpected response status code.");
        Assert.assertTrue(answer != null && !answer.isEmpty(), "Response answer is empty.");
        Assert.assertTrue(answer.toLowerCase().contains(disease.toLowerCase()),
                "Response does not contain the disease name: " + disease);

        // Print the result for clarity
        System.out.println("Condition Sent: " + disease);
        System.out.println("Response Answer: " + answer);
    }
}
