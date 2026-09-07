class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currentPrice = prices[0];
        for (int i =0 ; i<prices.length;i++){
            currentPrice = Math.min(prices[i], currentPrice);
            int profit = prices[i]-currentPrice;
            maxProfit = Math.max(profit , maxProfit);

        }
return maxProfit;
        
    }
}