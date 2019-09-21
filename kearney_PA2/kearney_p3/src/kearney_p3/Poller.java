package kearney_p3;
import java.util.Scanner;

public class Poller {
	
	// Prints the 5 x 10 table including the topic, and information about averages, minimums, and maximums
	private static void printSummary(String[] topics, int[][] ratingTable) {
		System.out.println("Table report:\n==================================================");
		
		int rowTotal[] = new int[5];
		
		// Prints table and gathers information on point totals for later display
		for (int i = 0; i < 5; i++) {
			System.out.printf("%s ", topics[i]);
			
			for (int j = 0; j < 10; j++) {
				System.out.printf("%d ", ratingTable[i][j]);
				rowTotal[i] += (j+1) * ratingTable[i][j];
			}
			
			// The average printed at the right side of each row
			System.out.printf("Average: %.2f\n", calculateAverage(ratingTable[i]));
			
		}
		System.out.println();
		
		// max and min are indices for rowTotal 
		int max = 0, min = 0;
		for (int i = 0; i < 5; i++) {
			if (rowTotal[i] > rowTotal[max]) 
				max = i;
			
			if (rowTotal[i] < rowTotal[min]) 
				min = i;
		}
		
		System.out.printf("Highest Point Total - Row: %d (%s), Total: %d\n", max + 1, topics[max], rowTotal[max]);
		System.out.printf("Lowest Point Total - Row: %d (%s), Total: %d\n", min + 1, topics[min], rowTotal[min]);

	}
	
	// Calculates the average rating for any given row
	private static double calculateAverage(int[] ratingRow) {
		double average = 0;
		int numResponses = 0;
		
		//
		for (int i = 0; i < 10; i++) {
			average += (double)((i + 1) * ratingRow[i]);
			numResponses += ratingRow[i];
		}
		
		return average / (double) numResponses;
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] topics = {"Critique", "Ontology", "Hermeneutics", "Immanence / Transcendence", "Genesis"};
		int[][] ratingTable = new int[5][10];
		int input = -1;
		
		// Initialize Table
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				ratingTable[i][j] = 0;
			}
		}
		
		// Polling loop, continues until a summary is requested
		System.out.println("Welcome to my poll, please rate each issue with a score from 1-10, with 1 as least, 10 as most important.");
		
		while (input != 0) {
			System.out.println("If you are not polling, input 0 to show poll results.  Otherwise input any number to continue.");
			
			input = in.nextInt();
			
			// Exit condition
			if (input == 0)
				continue;
			
			// Displays topic and acquires input
			for(int i = 0; i < 5; i++) {
				System.out.printf("%s [1-10]: ", topics[i]);
				
				// Error handling for invalid inputs
				try {
					input = in.nextInt();
					if (input > 10 || input < 1) {
						System.out.println("You fool, obey my instructions and only input 1-10");
						System.exit(-1);
					}
				} catch (Exception e) {
					System.out.println("You fool, obey my instructions and only input a whole number from 1-10");
					System.exit(-1);
				}
				
				// Adds an extra tally to the inputed rating.
				ratingTable[i][input-1]++;
			}
		}
		
		printSummary(topics, ratingTable);
	}
}
