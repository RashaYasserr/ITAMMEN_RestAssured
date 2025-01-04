package Models;

public class LoginRequest
{
    private String email;
    private String password;
    private int is_email;

    // Constructors, Getters, Setters
    public LoginRequest(String email, String password, int is_email)
    {
        this.email = email;
        this.password = password;
        this.is_email = is_email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getIs_email()
    {
        return is_email;
    }

    public void setIs_email(int is_email)
    {
        this.is_email = is_email;
    }
}
