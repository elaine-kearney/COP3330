package kearney_p1;

public class Crypter {
	// Splits an integer into an array of 4 integers, with the thousandths place at [0], the hundredths place at [1]...
	public int[] splitInteger(int inData) throws IllegalArgumentException {
		int[] splitInt = new int[4];
		
		if (inData / 10000 != 0) {
			throw new IllegalArgumentException("Value entered too high.");
		}
		
		// Splits the array
		for (int i = 0, place = 1000; i < 4; i++, place /= 10) {
			splitInt[i] = inData / place;
			
			// Remove the current place from the data (ex: 5200 -> 5200 - 5000 -> 200)
			inData -= splitInt[i] * place;
		}
		
		return splitInt;
	}
	
	
	// Both encrypts and decrypts, depending on the addFactor (7 for encrypt, 3 for decrypt)
	public int[] cryptArray(int[] splitInt, int addFactor) {
		int temp;
		
		for(int i = 0; i < 4; i++) {
			splitInt[i] = (splitInt[i] + addFactor) % 10;
		}
		
		
		// swap 1st place and 3rd place, and 2nd and 4th place
		for(int i = 0; i < 2; i++) {
			temp = splitInt[i + 2];
			splitInt[i + 2] = splitInt[i];
			splitInt[i] = temp;
		}
		
		return splitInt;
	}
	
	// Converts an array of integers into a single integer, treating the first entry as the thousandths, second as hundredths...
	public int unsplitInteger(int[] encryptedInt) {
		int unsplitInt = 0;
		
		for (int i = 0, place = 1000; i < 4; i++, place /= 10) {
			unsplitInt += encryptedInt[i] * place;
		}
		
		return unsplitInt;
	}
}
