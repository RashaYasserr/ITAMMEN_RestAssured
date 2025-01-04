package Utils;

public class BaseTest
{

    // Base URL for the API
    protected String baseUrl = "https://api.itammen.com";  // Replace with your API base URL

    // Store the token as a static variable
    protected static String token;

    public static String getToken()
    {
        return token;
    }
}