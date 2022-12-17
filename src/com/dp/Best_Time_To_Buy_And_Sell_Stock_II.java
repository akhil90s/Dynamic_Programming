package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_II {

	public static void main(String[] args) {

		int[] array = new int[] { 7, 1, 5, 3, 6, 4 };
		int result = maxProfit(array);
		System.out.println(result);
		
	}

	public static int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;
		int profit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}

}
