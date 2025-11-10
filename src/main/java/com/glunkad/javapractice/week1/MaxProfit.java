package com.glunkad.javapractice.week1;

public class MaxProfit {
    // TC : O(n^2) SC : O(1)
    public static int maxProfit1(int[] prices) {
        int profit = 0;
        int n = prices.length;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(prices[j] > prices[i]){
                    profit = Integer.max(profit, prices[j] - prices[i]);
                }
            }
        }
        return profit;
    }
    // TC : O(n) SC : O(1)
    private static int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int price : prices){
            minPrice = Integer.min(minPrice,price);
            profit = Integer.max(profit, price - minPrice);
        }
        return profit;
    }
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
//        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }


}
