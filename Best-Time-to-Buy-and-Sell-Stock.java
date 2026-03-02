1class Solution {
2    public int maxProfit(int[] prices) {
3    int min=prices[0];
4    int profit=0;
5    for(int i=1;i<prices.length;i++){
6      profit=Math.max(profit,prices[i]-min);
7      min=Math.min(min,prices[i]);
8    }
9       return profit;
10    }
11
12}
13