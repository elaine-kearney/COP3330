public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;
    public void calculateMonthlyInterest() {
        this.savingsBalance = this.savingsBalance + (savingsBalance * (annualInterestRate / 12.0));
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    SavingsAccount(double initialBalance) {
        this.savingsBalance = initialBalance;
    }
}
