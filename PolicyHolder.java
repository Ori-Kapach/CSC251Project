public class PolicyHolder {
    // Fields
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;
    //private double BMI;

    // Constructors
    public PolicyHolder() {
        // Default constructor
    }

    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
        //this.BMI = BMI;
    }

    // Getters and setters for the fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

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
    
    public double getBMI() {
    final double CONVERSION_FACTOR = 703;
    return (weight * CONVERSION_FACTOR) / (height * height);
    }
    
    public String GetBMI() {
        final double CONVERSION_FACTOR = 703;
        double BMI = (weight * CONVERSION_FACTOR) / (height * height);
        return String.format("%.2f", BMI);
    }

    // toString method to provide a string representation of the object's state
    @Override
    public String toString() {
        return 
                "Policyholder's First Name: " + firstName + '\n' +
                "Policyholder's Last Name: " + lastName + '\n' +
                "Policyholder's Age: " + age + '\n' +
                "Policyholder's Smoking Status (Y/N): " + smokingStatus + '\n' +
                "Policyholder's Height: " + height + " inches\n" +
                "Policyholder's Weight: " + weight + " pounds\n" + 
                "Policyholder's BMI: " + GetBMI();
    }
}