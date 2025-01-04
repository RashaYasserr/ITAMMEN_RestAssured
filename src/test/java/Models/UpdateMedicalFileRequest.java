package Models;

public class UpdateMedicalFileRequest
{

    private double height;
    private double weight;
    private String longTermDiseases;
    private String previousSurgeries;
    private String familyMedicalHistory;
    private String bloodType;
    private String allergies;
    private String medicalNotes;
    private String dob;

    // Constructor
    public UpdateMedicalFileRequest(double height, double weight, String longTermDiseases, String previousSurgeries,
                                    String familyMedicalHistory, String bloodType, String allergies,
                                    String medicalNotes, String dob)
    {
        this.height = height;
        this.weight = weight;
        this.longTermDiseases = longTermDiseases;
        this.previousSurgeries = previousSurgeries;
        this.familyMedicalHistory = familyMedicalHistory;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.medicalNotes = medicalNotes;
        this.dob = dob;
    }

    // Getters and Setters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLongTermDiseases() {
        return longTermDiseases;
    }

    public void setLongTermDiseases(String longTermDiseases) {
        this.longTermDiseases = longTermDiseases;
    }

    public String getPreviousSurgeries() {
        return previousSurgeries;
    }

    public void setPreviousSurgeries(String previousSurgeries) {
        this.previousSurgeries = previousSurgeries;
    }

    public String getFamilyMedicalHistory() {
        return familyMedicalHistory;
    }

    public void setFamilyMedicalHistory(String familyMedicalHistory) {
        this.familyMedicalHistory = familyMedicalHistory;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString()
    {
        return "{" +
                "\"height\":" + height +
                ", \"weight\":" + weight +
                ", \"long_term_diseases\":\"" + longTermDiseases + '\'' +
                ", \"previous_surgeries\":\"" + previousSurgeries + '\'' +
                ", \"family_medical_history\":\"" + familyMedicalHistory + '\'' +
                ", \"blood_type\":\"" + bloodType + '\'' +
                ", \"allergies\":\"" + allergies + '\'' +
                ", \"medical_notes\":\"" + medicalNotes + '\'' +
                ", \"dob\":\"" + dob + '\'' +
                '}';
    }
}
