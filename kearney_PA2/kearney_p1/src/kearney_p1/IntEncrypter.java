package kearney_p1;
import static java.lang.System.out;
import java.util.Scanner;


public class IntEncrypter {
	public static void main(String[] args) {
		Crypter encrypter = new Crypter();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a number to be encrypted: ");
		try {
			int inData = in.nextInt();
			
			// Processes the user inputted number using the Crypter class methods (added for generity)
			int outData = encrypter.unsplitInteger(encrypter.cryptArray(encrypter.splitInteger(inData), 7));
			
			System.out.printf("\nSuccess!  Your encrypted number is: %d", outData);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
}
