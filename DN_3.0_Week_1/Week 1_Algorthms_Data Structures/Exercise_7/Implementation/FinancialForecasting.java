//Recursive Algorithm to Predict Future Values

public class FinancialForecasting {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        // Base case: If no years left to grow, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Recursive case: Calculate the value for the next year
        double nextValue = currentValue * (1 + growthRate);
        return calculateFutureValue(nextValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // Initial value
        double annualGrowthRate = 0.05; // 5% annual growth rate
        int years = 10; // Number of years to predict

        double futureValue = calculateFutureValue(initialValue, annualGrowthRate, years);
        System.out.println("The future value after " + years + " years is: " + futureValue);
    }
}
