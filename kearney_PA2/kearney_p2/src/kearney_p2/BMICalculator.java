package kearney_p2;
import java.util.Scanner;

public class BMICalculator {
	private static double calcMetric (double height, double weight) {
		return weight / (height * height);
	}
	
	private static double calcImperial (double height, double weight) {
		return (703 * weight) / (height * height);
	}
	
	private static double calcGeneric(double height, double weight, int unitFlag) {
		return (unitFlag == 0) ? calcMetric(height, weight) : calcImperial(height, weight);
	}
	
	private static void displayCategories (double BMI) {
		String display = "";
		
		if(BMI < 18.5)
			display = "Underweight";
		else if (BMI < 24.9)
			display = "Normal Weight";
		else if (BMI < 29.9)
			display = "Overweight";
		else
			display = "Obese";
		
		System.out.printf("\nYour BMI is: %.1f\n", BMI);
		System.out.printf("You are %s\n", display);
		
		System.out.println("\nBMI Categories:");
		System.out.println("   Underweight = < 18.5");
		System.out.println("   Normal Weight = 18.5 - 24.9");
		System.out.println("   Overweight = 25 - 29.9");
		System.out.println("   Obese = > 30.0");
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int unitFlag = 0;
		double height = 0, weight = 0;
		String heightName = "", weightName = "";
		
		// Wrap all the input methods in a try
		try {
			System.out.print("Choose your units.  Select 0 for metric, 1 for imperial: ");
			unitFlag = in.nextInt();
			
			// Set the unit names based on user selection
			if (unitFlag == 0) {
				heightName = "meters";
				weightName = "kilograms";
			}
			else if (unitFlag == 1) {
				heightName = "inches";
				weightName = "pounds";
			}
			else {
				System.out.println("Error: Unit selection input must be 0 or 1.");
				System.exit(-1);
			}
			
			System.out.printf("Please enter your height in %s: ", heightName);
			height = in.nextDouble();
			System.out.printf("Please enter your weight in %s: ", weightName);
			weight = in.nextDouble();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		double BMI = calcGeneric(height, weight, unitFlag);
		displayCategories(BMI);
	}
}
