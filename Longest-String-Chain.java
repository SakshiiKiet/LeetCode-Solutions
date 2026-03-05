1class Solution {
2    public int longestStrChain(String[] words) {
3        int n=words.length;
4        Arrays.sort(words, (a,b) -> a.length() - b.length());
5        int[]dp=new int[n];
6        int max=1;
7        Arrays.fill(dp,1);
8        for(int i=0;i<n;i++){
9            for(int prev=0;prev<i;prev++){
10                if(checkPossible(words[i], words[prev]) && 1+dp[prev]>dp[i] ){
11                    dp[i]=1+dp[prev];
12                }
13            }
14            max=Math.max(max,dp[i]);
15        }
16        return max;
17    }
18    boolean checkPossible(String s1,String s2){
19        if(s1.length() != s2.length()+1) return false;
20        int i=0;
21        int j=0;
22        while(i<s1.length()){
23        if(j < s2.length() && s1.charAt(i) == s2.charAt(j)){
24            i++;j++;
25        }else{
26            i++;
27        }
28        }
29        if(i==s1.length() && j==s2.length()) return true;
30        return false;
31    }
32}