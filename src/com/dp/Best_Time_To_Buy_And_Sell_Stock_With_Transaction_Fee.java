package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 3, 2, 8, 4, 9 };
		int result_Tabulation = maxProfit_Tabulation(array, 2);
		System.out.println(result_Tabulation);

	}

	public static int maxProfit_Tabulation(int[] prices, int fee) {

		int n = prices.length;
		if (n <= 1)
			return 0;

		int[][] dp = new int[n][2];

		dp[0][0] = 0;
		dp[0][1] = -prices[0] - fee;

		for (int i = 1; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
			dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
		}

		return dp[n - 1][0];
	}

}
