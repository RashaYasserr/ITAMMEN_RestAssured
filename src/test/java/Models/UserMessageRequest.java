package Models;

public class UserMessageRequest
{
    private String user_message;

    // Constructor
    public UserMessageRequest(String user_message)
    {
        this.user_message = user_message;
    }

    // Getter and Setter
    public String getUser_message()
    {
        return user_message;
    }

    public void setUser_message(String user_message)
    {
        this.user_message = user_message;
    }
}
