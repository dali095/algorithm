package kai.leetcode.algorithm.best_time_to_buy_and_sell_stock;

//
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        
        int sell = prices.length - 1;
        int buy = 0;
        int profit = 0;
        
        while (buy < sell && prices[buy] > prices[buy + 1])
            buy++;
        while (buy < sell && prices[sell] < prices[sell - 1])
            sell--;
        if (profit < prices[sell] - prices[buy])
            profit = prices[sell] - prices[buy];
        if (sell == buy)
            return profit;
        for (int i = buy; i < sell; i++) {
            if (prices[i] > prices[sell]){
                if (profit < prices[i] - prices[buy])
                    profit = prices[i] - prices[buy];
            } else if (prices[i] < prices[buy]){
                buy = i;
                if (profit < prices[sell] - prices[buy])
                    profit = prices[sell] - prices[buy];
            }
        }
        return profit;
    }
}
