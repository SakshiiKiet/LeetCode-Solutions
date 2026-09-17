class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        
       for(int j=0;j<=amount;j++){
          if(j%coins[0]==0){
                prev[j]= j/coins[0];
            }else{
             prev[j]=Integer.MAX_VALUE/2;
            }
       }
        if(amount==0) return 0;
        for(int i=1;i<n;i++){
            int[] temp=new int[amount+1];
            for(int j=0;j<=amount;j++){
              int not=prev[j];
        int take=Integer.MAX_VALUE/2;
        if(j>=coins[i]){
            take=1+temp[j-coins[i]];
        }
       temp[j]=Math.min(take,not);
            }
            prev=temp;
        }
        
      int ans = prev[amount];

        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}