public class Policy {
    // Fields
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder; // Reference to PolicyHolder object

    // Static field to track number of Policy objects created
    private static int numberOfPolicies = 0;

    // Constructors
    public Policy() {
        numberOfPolicies++;
    }

    public Policy(String policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
        numberOfPolicies++;
    }

    // Getters and setters for the fields
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public static int getNumberOfPolicies() {
        return numberOfPolicies;
    }

    // toString method
    @Override
    public String toString() {
        return 
                "Policy Number: " + policyNumber + '\n' +
                "Provider Name: " + providerName + '\n' + policyHolder;
    }
    
    
     
     public double getPrice() 
          {
               final double BASE_PRICE = 600;
               final double ADDITIONAL_FEE_AGE = 75;
               final double ADDITIONAL_FEE_SMOKING = 100;
               final double ADDITIONAL_FEE_PER_BMI = 20;

               final int AGE_THRESHOLD = 50;
               final int BMI_THRESHOLD = 35;

               double price = BASE_PRICE;

               if (policyHolder.getAge() > AGE_THRESHOLD)
               price += ADDITIONAL_FEE_AGE;

               if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
               price += ADDITIONAL_FEE_SMOKING;

               if (policyHolder.getBMI() > BMI_THRESHOLD)
               price += ((policyHolder.getBMI() - BMI_THRESHOLD) * ADDITIONAL_FEE_PER_BMI);

               return price;
          }
}

