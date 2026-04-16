1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxlen=0;
4        for(int i=0;i<s.length();i++){
5            int[] hash=new int[256];
6            for(int j=i;j<s.length();j++){
7               if(hash[s.charAt(j)]==1){
8                break;
9               }
10               hash[s.charAt(j)]=1;
11               maxlen=Math.max(maxlen,j-i+1);
12            }
13        }
14        return maxlen;
15    }
16}