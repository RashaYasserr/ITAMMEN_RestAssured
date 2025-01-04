package tests.AiConversations;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.BaseTest;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PreviousQuestionHistoryTest extends BaseTest
{

    @Test(priority = 1, dependsOnMethods = "login")
    public void testPreviousQuestionHistory()
    {
        // Ensure token exists
        Assert.assertNotNull(token, "Token is null. Ensure login test ran successfully.");

        // Send GET request to fetch conversation history
        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .get(baseUrl + "/api/profile/conversation-history");

        // Validate response status code
        Assert.assertEquals(response.getStatusCode(), 200,
                "Unexpected response status code.");

        // Extract 'items' from the response
        List<Map<String, Object>> items = response.jsonPath().getList("items");
        Assert.assertTrue(items.size() > 0, "No conversation history found.");

        // Verify required fields and their values in each record
        for (Map<String, Object> item : items)
        {
            Assert.assertTrue(item.containsKey("id"), "Missing 'id' field.");
            Assert.assertTrue(item.containsKey("user_message"), "Missing 'user_message' field.");
            Assert.assertTrue(item.containsKey("ai_message"), "Missing 'ai_message' field.");
            Assert.assertTrue(item.containsKey("created_at"), "Missing 'created_at' field.");

            // Ensure fields are not null or empty
            Integer id = (Integer) item.get("id");
            String userMessage = (String) item.get("user_message");
            String aiMessage = (String) item.get("ai_message");
            String createdAt = (String) item.get("created_at");

            Assert.assertNotNull(id, "ID should not be null.");
            Assert.assertNotNull(userMessage, "User message should not be null.");
            Assert.assertNotNull(aiMessage, "AI message should not be null.");
            Assert.assertNotNull(createdAt, "Created_at should not be null.");

            // Print some of the data for clarity
            System.out.println("Record ID: " + id);
            System.out.println("User Message: " + userMessage);
            System.out.println("AI Message: " + aiMessage.substring(0, Math.min(50, aiMessage.length())) + "...");
            System.out.println("Created At: " + createdAt);
            System.out.println("------------------------------------------------------");
        }

        // Verify total matches the number of items
        int total = response.jsonPath().getInt("total");
        Assert.assertEquals(total, items.size(), "Total count does not match the number of items returned.");

        // Verify records are sorted by 'created_at' in descending order
        for (int i = 0; i < items.size() - 1; i++)
        {
            String currentDate = (String) items.get(i).get("created_at");
            String nextDate = (String) items.get(i + 1).get("created_at");
            Assert.assertTrue(currentDate.compareTo(nextDate) >= 0, "Records are not sorted by 'created_at' in descending order.");
        }
    }
}
