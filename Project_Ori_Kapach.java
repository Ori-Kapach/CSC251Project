import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Project_Ori_Kapach {
    public static void main(String[] args) {
        String filename = "PolicyInformation.txt"; // Specify the file name directly with correct path

        // List to store policy information
        List<Policy> policies = new ArrayList<>();

        // Read the policy information from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int policyNumber = Integer.parseInt(line);
                String providerName = reader.readLine();
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                int age = Integer.parseInt(reader.readLine());
                String smokingStatus = reader.readLine();
                double height = Double.parseDouble(reader.readLine());
                double weight = Double.parseDouble(reader.readLine());

                // Create Policy object and add to list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                // Skip the empty line between policy entries
                reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        // Display the policy information
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n\n", policy.calculatePolicyPrice());
        }

        // Count smokers and non-smokers
        int smokersCount = 0;
        int nonSmokersCount = 0;
        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokersCount++;
            } else {
                nonSmokersCount++;
            }
        }
        System.out.println("The number of policies with a smoker is: " + smokersCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokersCount);
    }
}
