/*
Theory Questions :
Explain the concept of recursion and how it can simplify certain problems.

Answer :
A method where the solution to a problem depends on solutions to smaller instances of the same problem.
The function calls itself until base case terminates the recursion.
 */
public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future Value after " + years + "\nyears: " + futureValue);
    }
}
