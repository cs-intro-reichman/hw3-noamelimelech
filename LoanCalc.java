public class LoanCalc {
    static double epsilon = 0.01;
    static int iterationCounter;
    
    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);
        
        System.out.print("\nPeriodical payment, using brute force: ");
        double p1 = bruteForceSolver(loan, rate, n, epsilon);
        System.out.println((int) p1);
        System.out.println("number of iterations: " + iterationCounter);
        
        System.out.print("\nPeriodical payment, using bi-section search: ");
        double p2 = bisectionSolver(loan, rate, n, epsilon);
        System.out.println((int) p2);
        System.out.println("number of iterations: " + iterationCounter);
    }
    
    private static double endBalance(double loan, double rate, int n, double payment) {
        double r = rate / 100.0;
        double balance = loan;
        for (int i = 0; i < n; i++) {
            balance = (balance - payment) * (1.0 + r);
        }
        return balance;
    }
    
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double payment = loan / n;
        
        while (endBalance(loan, rate, n, payment) > 0.0) {
            payment += epsilon;
            iterationCounter++;
        }
        return payment;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double low = 0.0;
        double high = loan;
        
        //לבדוק high
        while (endBalance(loan, rate, n, high) > 0.0) {
            high *= 2.0;
        }
        
        // בדיקה של ערך גבוה ונמול
        while ((high - low) > epsilon) {
            iterationCounter++;
            double mid = (low + high) / 2.0;
            
            if (endBalance(loan, rate, n, mid) > 0.0) {
                low = mid;   // Payment too low, need higher payment
            } else {
                high = mid;  // Payment too high or just right
            }
        }
        return (low + high) / 2.0;
    }
}