1class Solution {
2    int[][]dp;
3    public int change(int amount, int[] coins) {
4        int n=coins.length;
5        dp=new int [n][amount+1];
6    
7    for(int t=0;t<=amount;t++){
8        if(t%coins[0]==0){
9            dp[0][t]=1;
10        }else{
11            dp[0][t]=0;
12        }
13    }
14    for(int i=1;i<n;i++){
15        for( int j=0;j<=amount;j++){
16        int notTake=dp[i-1][j];
17        int take=0;
18        if(j>=coins[i]){
19            take=dp[i][j-coins[i]];
20        }
21         dp[i][j]=take+notTake;
22        }
23    }
24        return dp[n-1][amount];
25    }
26        }
27    