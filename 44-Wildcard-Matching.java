class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new Boolean[n+1][m+1];
        return solve(n,m,s,p);
    }
    boolean solve(int i,int j,String s, String p){
        if(i==0 && j==0) return true;
        if(j==0 && i>0) return false;
        if(i==0 && j>0){
            for(int ii=1;ii<=j;ii++){
                if(p.charAt(ii-1)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
           return dp[i][j]= solve(i-1,j-1,s,p);
        }if(p.charAt(j-1)=='*'){
           return dp[i][j]= solve(i,j-1,s,p) || solve(i-1,j,s,p); 
        }
       return dp[i][j]= false;
    }
}