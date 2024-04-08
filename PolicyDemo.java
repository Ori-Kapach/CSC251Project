import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class PolicyDemo {
    public static void main(String[] args) throws IOException {
        // Declare variables
        String policyNumber;
        String providerName;
        String firstName;
        String lastName;
        int age;
        String smokingStatus;
        double height;
        double weight;
        double BMI;
        int numSmokers = 0;

        // ArrayList to store Policy objects
        ArrayList<Policy> policyList = new ArrayList<>();

        // Create and open the file
        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        // Process all information in the file
        while (inputFile.hasNext()) {
            policyNumber = inputFile.nextLine();
            providerName = inputFile.nextLine();
            firstName = inputFile.nextLine();
            lastName = inputFile.nextLine();
            age = inputFile.nextInt();
            inputFile.nextLine();
            smokingStatus = inputFile.nextLine();
            height = inputFile.nextDouble();
            weight = inputFile.nextDouble();
            

            // Make sure we haven't hit the end of the file before trying to skip the blank line
            if (inputFile.hasNext())
                inputFile.nextLine();
            if (inputFile.hasNext())
                inputFile.nextLine();

            // Create a PolicyHolder object
            PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);

            // Create a Policy object and add it to our ArrayList
            policyList.add(new Policy(policyNumber, providerName, policyHolder));

            // Keep track of the number of smokers
            if (smokingStatus.equalsIgnoreCase("smoker"))
                numSmokers++;
        }

        // Print out information about each Policy object
        for (Policy policy : policyList) {
            System.out.println(policy);
            System.out.printf("Policy Price: $%.2f\n", policy.getPrice());
            System.out.println();
        }
        
        

        // Print out the number of smokers and non-smokers
        System.out.println("There were " + Policy.getNumberOfPolicies() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + numSmokers);
        System.out.println("The number of policies with a non-smoker is: " + (Policy.getNumberOfPolicies() - numSmokers));
    }
}