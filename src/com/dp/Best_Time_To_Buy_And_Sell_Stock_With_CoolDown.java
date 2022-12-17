package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_With_CoolDown {

	public static void main(String[] args) {

		int[] array = new int[] { 1, 2, 3, 0, 2 };
		int result = maxProfit(array);
		System.out.println(result);

	}
	
    /*
    Dynamic Array = dp[prices.length][2];
    Case 1 - I have the stock today on day i, dp[i][1] is the max of the below:
        - I bought the stock today
          dp[i - 2][0] - prices[i]
        - I am carrying foward the stock
          dp[i - 1][1]
          
    Case 2 - I have no stock today on day i, dp[i][0] is the max of the below:
        - I sold the stock today
          dp[i - 1][1] + prices[i]
        - I am carrying foward doing nothing as of now
          dp[i - 1][0]    
    */
	
	public static int maxProfit(int[] prices) {

		int n = prices.length;
		if (n <= 1)
			return 0;

		if (n == 2 & prices[1] > prices[0]) {
			return prices[1] - prices[0];
		} else if (n == 2 && prices[0] > prices[1]) {
			return 0;
		}
		int[][] dp = new int[n][2];

		dp[0][0] = 0;
		dp[0][1] = -prices[0];
		dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
		dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

		for (int i = 2; i < n; i++) {
			dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
			dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
		}
		return dp[n - 1][0];
		
	}

}
