public class LoanCalc {

    static double epsilon = 0.001;
    static int iterationCounter;

    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double ratePercent = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        double r = ratePercent / 100.0;

        System.out.println("Loan = " + loan + ", interest rate = " + ratePercent + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        double p1 = bruteForceSolver(loan, r, n, epsilon);
        System.out.println((int) p1);
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        double p2 = bisectionSolver(loan, r, n, epsilon);
        System.out.println((int) p2);
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double r, int n, double payment) {
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance = (balance - payment) * (1.0 + r);
        }
        return balance;
    }

    public static double bruteForceSolver(double loan, double r, int n, double epsilon) {
        iterationCounter = 0;
        double payment = loan / n;
        while (endBalance(loan, r, n, payment) > 0.0) {
            payment += epsilon;
            iterationCounter++;
        }
        return payment;
    }

    public static double bisectionSolver(double loan, double r, int n, double epsilon) {
        iterationCounter = 0;
        double low = 0.0, high = loan;
        while (endBalance(loan, r, n, high) > 0.0) high *= 2.0;
        while ((high - low) > epsilon) {
            iterationCounter++;
            double mid = (low + high) / 2.0;
            if (endBalance(loan, r, n, mid) > 0.0) low = mid; else high = mid;
        }
        return (low + high) / 2.0;
    }
}
