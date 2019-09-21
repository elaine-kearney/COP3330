package kearney_p1;
import static java.lang.System.out;
import java.util.Scanner;


public class IntDecrypter {
	public static void main(String[] args) {
		Crypter encrypter = new Crypter();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a number to be decrypted: ");
		try {
			int inData = in.nextInt();
			
			// Processes the user inputted number using the Crypter class methods (added for generity)
			int outData = encrypter.unsplitInteger(encrypter.cryptArray(encrypter.splitInteger(inData), 3));
			
			System.out.printf("\nSuccess!  Your decrypted number is: %d", outData);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
}
