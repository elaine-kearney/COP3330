import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class ComputerAssistedInstruction {
    private String[] positiveResponses = {"Very Good!", "Excellent!", "Nice Work!", "Keep up the good work!"};
    private String[] negativeResponses = {"No. Please try again.", "Wrong. Try once more.",
            "Don’t give up!", "No. Keep trying."};

    private static double generateQuestion(SecureRandom secureRandom, int upperBound, int operator) {
        // If the user inputs random question mode, generate a random operator
        if(operator == 4)
            operator = secureRandom.nextInt(4);

        int firstTerm, secondTerm;
        double answer = 0.0;

        firstTerm = secureRandom.nextInt(upperBound);
        // Change how second term generates numbers in division cases to eliminate divide by zero
        secondTerm = operator != 3 ? secureRandom.nextInt(upperBound) : secureRandom.nextInt(upperBound - 1) + 1;

        switch (operator) {
            case 0:
                System.out.printf("How much is %d plus %d? ", firstTerm, secondTerm);
                answer = (double)firstTerm + secondTerm;
                break;
            case 1:
                System.out.printf("How much is %d times %d? ", firstTerm, secondTerm);
                answer = (double)firstTerm * secondTerm;
                break;
            case 2:
                System.out.printf("How much is %d minus %d? ", firstTerm, secondTerm);
                answer = (double)firstTerm - secondTerm;
                break;
            case 3:
                System.out.printf("How much is %d divided by %d? (To 2 decimals, round down) ", firstTerm, secondTerm);
                answer = (double)firstTerm / (double)secondTerm;

                // Round answer to 2 decimal places
                answer = Math.floor(answer * 100) / 100;
                break;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int difficultyLevel = 0, questionMode = 0, numCorrect = 0;
        SecureRandom secureRandom = new SecureRandom();
        double input, answer;

        while (true) {

            questionMode = 0;
            difficultyLevel = 0;
            numCorrect = 0;
            if (in.nextInt() == 1)
                break;

            while (difficultyLevel < 1 || difficultyLevel > 4) {
                System.out.print("Please enter a difficulty level (1-4): ");
                difficultyLevel = in.nextInt();
            }

            while (questionMode < 1 || questionMode > 5) {
                System.out.print("\n  1: Addition\n" +
                        "  2: Multiplication\n" +
                        "  3: Subtraction\n" +
                        "  4: Division\n" +
                        "  5: Random\n" +
                        "Please select an arithmetic problem to study (1-5): ");

                questionMode = in.nextInt();
            }

            // Generate 10 questions
            for (int i = 0; i < 10; i++) {
                answer = generateQuestion(secureRandom, (int) Math.pow(10, difficultyLevel), questionMode - 1);

                // Since division is most likely going to be a decimal, we natively take a double to make input easier
                if (questionMode == 4)
                    input = in.nextDouble();
                else
                    input = in.nextDouble();

                if (input == answer)
                    numCorrect++;
            }

            if(((double)numCorrect / 10.0) < .75)
                System.out.println("Please ask your teacher for extra help.");
            else
                System.out.println("Congratulations, you are ready to go to the next level!");

            System.out.print("Input 0 to quit, otherwise input any number to continue: ");
            if(in.nextInt() == 0)
                break;
        }
    }
}
