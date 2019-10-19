public class SavingsTester {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000 );
        SavingsAccount saver2 = new SavingsAccount(3000 );

        SavingsAccount.modifyInterestRate(.04);

        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        System.out.printf("Balance for Saving Account 1: $%.02f\n", saver1.getSavingsBalance());
        System.out.printf("Balance for Saving Account 2: $%.02f\n", saver2.getSavingsBalance());

        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Balance for Saving Account 1: $%.02f\n", saver1.getSavingsBalance());
        System.out.printf("Balance for Saving Account 2: $%.02f\n", saver2.getSavingsBalance());

    }
}
