1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[] ahead=new int[4+1];
5        for(int trans=0;trans<=4;trans++){
6            ahead[trans]=0;
7        }
8        for(int i=n-1;i>=0;i--){
9            int[] curr=new int[4+1];
10            curr[4]=0;
11          for(int trans=3;trans>=0;trans--){
12             if(trans%2==0){ //buy
13          curr[trans]=Math.max(-prices[i]+ahead[trans+1],0+ahead[trans]);
14        }else{
15           curr[trans]=Math.max(prices[i]+ahead[trans+1],0+ahead[trans]) ;
16        }
17          }
18          ahead=curr;
19        }
20       
21        return ahead[0];
22    }
23}