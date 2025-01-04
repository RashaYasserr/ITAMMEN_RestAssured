package Models;


public class UpdateProfileRequest
{

    private String name;
    private String dob;
    private int gender;

    // Constructor to initialize the request data
    public UpdateProfileRequest(String name, String dob, int gender)
    {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    // Getters and setters for the fields
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }
}
