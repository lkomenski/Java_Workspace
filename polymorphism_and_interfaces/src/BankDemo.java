import java.util.ArrayList;

public class BankDemo {

    // ===== Strategy Interface =====
    interface InterestStrategy {
        double calculate(double balance);
    }

    // Two concrete strategies
    static class SimpleInterest implements InterestStrategy {
        private final double rate; // ex: 0.02 = 2%

        SimpleInterest(double rate) {
            this.rate = rate;
        }

        @Override
        public double calculate(double balance) {
            return balance * rate;
        }
    }

    static class TieredInterest implements InterestStrategy {
        @Override
        public double calculate(double balance) {
            // Simple tier example: < 1000 => 1%, otherwise 3%
            if (balance < 1000) return balance * 0.01;
            return balance * 0.03;
        }
    }

    // ===== Base class =====
    static class Account {
        private final String owner;
        private double balance;

        // Strategy composed into Account
        private InterestStrategy interestStrategy;

        public Account(String owner, double balance, InterestStrategy interestStrategy) {
            if (owner == null || owner.isBlank())
                throw new IllegalArgumentException("owner required");
            if (balance < 0)
                throw new IllegalArgumentException("balance must be >= 0");
            if (interestStrategy == null)
                throw new IllegalArgumentException("strategy required");

            this.owner = owner;
            this.balance = balance;
            this.interestStrategy = interestStrategy;
        }

        public void deposit(double amount) {
            if (amount <= 0)
                throw new IllegalArgumentException("deposit must be > 0");
            balance += amount;
        }

        // Method expected to vary => overridable
        public void withdraw(double amount) {
            if (amount <= 0)
                throw new IllegalArgumentException("withdraw must be > 0");

            double total = withdrawalTotal(amount); // hook method
            if (total <= balance) {
                balance -= total;
                afterSuccessfulWithdraw(); // optional hook
            }
        }

        // Protected hook method (subclasses may vary behavior)
        protected double withdrawalTotal(double amount) {
            return amount;
        }

        // Optional hook for subclasses
        protected void afterSuccessfulWithdraw() { }

        public double getBalance() {
            return balance;
        }

        public void setInterestStrategy(InterestStrategy s) {
            if (s == null)
                throw new IllegalArgumentException("strategy cannot be null");
            this.interestStrategy = s;
        }

        // Uses the strategy
        public void applyInterest() {
            balance += interestStrategy.calculate(balance);
        }

        public String getOwner() {
            return owner;
        }

        public String getStrategyName() {
            return interestStrategy.getClass().getSimpleName();
        }
    }

    // ===== Subclasses =====
    static class SavingsAccount extends Account {
        private int withdrawalsLeft;

        public SavingsAccount(String owner, double balance, InterestStrategy interestStrategy, int withdrawalLimit) {
            super(owner, balance, interestStrategy);
            this.withdrawalsLeft = withdrawalLimit;
        }

        // SavingsAccount may limit withdrawals
        @Override
        public void withdraw(double amount) {
            if (withdrawalsLeft > 0) {
                super.withdraw(amount);
            }
        }

        @Override
        protected void afterSuccessfulWithdraw() {
            withdrawalsLeft--;
        }
    }

    static class CheckingAccount extends Account {
        private final double fee; // per-transaction fee

        public CheckingAccount(String owner, double balance, InterestStrategy interestStrategy, double fee) {
            super(owner, balance, interestStrategy);
            this.fee = fee;
        }

        // CheckingAccount may apply per-transaction fees
        @Override
        protected double withdrawalTotal(double amount) {
            return amount + fee;
        }
    }

    // ===== Main method demo =====
    public static void main(String[] args) {
        // Each account holds its own strategy instance
        SavingsAccount savings = new SavingsAccount("Joe", 1200.00, new SimpleInterest(0.02), 2);
        CheckingAccount checking = new CheckingAccount("Sally", 500.00, new SimpleInterest(0.00), 1.50);

        // === Start ===
        System.out.println("=== Start ===");

        System.out.println("Savings Balance: $" + savings.getBalance());
        System.out.println("Strategy: " + savings.getStrategyName());
        System.out.println();

        System.out.println("Checking Balance: $" + checking.getBalance());
        System.out.println("Strategy: " + checking.getStrategyName());
        System.out.println();

        // Demonstrate polymorphism
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(checking);

        // === Polymorphism ===
        System.out.println("=== Polymorphism: ArrayList<Account> ===");

        for (Account a : accounts) {

            // Perform shared operation
            a.deposit(100);
            a.withdraw(200);

            System.out.println(a.getClass().getSimpleName());
            System.out.println("Owner: " + a.getOwner());
            System.out.println("Balance: $ " + a.getBalance());
            System.out.println();
        }
        System.out.println();

        // === Strategy Swap ===
        System.out.println("=== Strategy Swap (Savings) ===");

        System.out.println("Before interest: $" + savings.getBalance());
        System.out.println("Strategy: " + savings.getStrategyName());
        System.out.println();

        savings.applyInterest();

        System.out.println("After interest: $" + savings.getBalance());
        System.out.println("Strategy: " + savings.getStrategyName());
        System.out.println();

        savings.setInterestStrategy(new TieredInterest());
        savings.applyInterest();

        System.out.println("After swap+interest: $" + savings.getBalance());
        System.out.println("Strategy: " + savings.getStrategyName());

        /*
         Open/Closed:
         To add a new interest type, create a new class that implements InterestStrategy.
         No changes are needed in Account, SavingsAccount, or CheckingAccount.
         */
    }
}