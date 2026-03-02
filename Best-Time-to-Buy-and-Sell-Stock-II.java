1class Solution {
2    public int maxProfit(int[] prices) {
3        int n=prices.length;
4      
5       int currbuy,currNotbuy,aheadbuy,aheadNotbuy;
6        aheadbuy=aheadNotbuy=0;
7        for(int i=n-1;i>=0;i--){
8            currNotbuy=Math.max(prices[i]+aheadbuy,0+aheadNotbuy);
9            currbuy=Math.max(-prices[i]+aheadNotbuy,0+aheadbuy);
10            aheadbuy=currbuy;
11            aheadNotbuy=currNotbuy;
12        }
13        return aheadbuy;
14    }
15}