package Models;

public class SignUpRequest {
    private int is_email; // 0 for phone, 1 for email
    private String email; // Optional if `is_email` is 1
    private String phone; // Optional if `is_email` is 0
//    private String name; // Optional field
//    private Integer gender; // Optional field, 1 for male, 2 for female
//    private String dob; // Optional field, date of birth

    // Constructor
    public SignUpRequest(int is_email, String email, String phone)

    {
        this.is_email = is_email;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getIs_email() {
        return is_email;
    }

    public void setIs_email(int is_email) {
        this.is_email = is_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
