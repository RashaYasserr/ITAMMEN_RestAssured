package tests.AiConversations;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import static io.restassured.RestAssured.given;

public class ChatGptValidationTest extends BaseTest
{

    @Test(dependsOnMethods = "tests.AiConversations.AiConversationTest.ASkQuestion")
    public void validateResponseWithChatGpt()
    {
        // Retrieve the response answer from the ASkQuestion test
        String answerFromApi = AiConversationTest.getLatestAnswer();
        Assert.assertNotNull(answerFromApi, "No answer was retrieved from the ASkQuestion test.");

        // Call ChatGPT API with the same disease
        String chatGptResponse = callChatGptApi(answerFromApi);

        // Print both responses for comparison
        System.out.println("Response from Your API: " + answerFromApi);
        System.out.println("Response from ChatGPT: " + chatGptResponse);

        // Assertions: Validate the answer content matches ChatGPT's content
        Assert.assertTrue(chatGptResponse.toLowerCase().contains("headache"),
                "ChatGPT response does not contain the expected disease keyword.");

        Assert.assertTrue(chatGptResponse.length() > 50,
                "ChatGPT response appears to be too short or incomplete.");

        System.out.println("ChatGPT Validation Passed Successfully!");
    }

    // Helper method to call ChatGPT API
    private String callChatGptApi(String userMessage)
    {
        String chatGptApiKey = "your_openai_api_key";
        String chatGptEndpoint = "https://api.openai.com/v1/chat/completions";

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + chatGptApiKey)
                .body("{ \"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"" + userMessage + "\"}] }")
                .when()
                .post(chatGptEndpoint);

        // Extract the 'content' field from the ChatGPT response
        return response.jsonPath().getString("choices[0].message.content");
    }
}
