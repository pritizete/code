public class ZeroOneKnapsack {

    public static int knapsackDP(int capacity, int[] wt, int[] val, int n) {
        // dp[i][w] stores max value using first 'i' items with capacity 'w'
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                // Base Case: No items or 0 capacity yields 0 value
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } 
                // If weight of current item is less than or equal to current capacity
                else if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i - 1][w - wt[i - 1]], // Include item
                        dp[i - 1][w]                           // Exclude item
                    );
                } 
                // Weight of current item is greater than current capacity
                else {
                    dp[i][w] = dp[i - 1][w]; // Exclude item
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;
        int n = val.length;

        int maxProfit = knapsackDP(capacity, wt, val, n);
        System.out.println("Maximum value in 0-1 Knapsack = " + maxProfit);
    }
}