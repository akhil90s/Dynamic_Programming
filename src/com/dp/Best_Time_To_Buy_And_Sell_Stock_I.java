package com.dp;

public class Best_Time_To_Buy_And_Sell_Stock_I {

	public static void main(String[] args) {

		int[] array = new int[] { 7, 1, 5, 3, 6, 4 };
		int result_maxProfit_Approach1 = maxProfit_Approach1(array);
		System.out.println(result_maxProfit_Approach1);

		int result_maxProfit_Approach2 = maxProfit_Approach2(array);
		System.out.println(result_maxProfit_Approach2);

	}

	public static int maxProfit_Approach1(int[] prices) {

		int min = Integer.MAX_VALUE;
		int profit = 0;
		for (int price : prices) {
			min = Math.min(min, price);
			profit = Math.max(profit, price - min);
		}
		return profit;
	}

	public static int maxProfit_Approach2(int[] prices) {

		if (prices.length == 0 || prices == null)
			return 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}

}
