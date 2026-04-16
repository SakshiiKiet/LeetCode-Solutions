1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3      int[] hash=new int[256];
4      Arrays.fill(hash,-1);
5      int maxlen=0;
6      int l=0,r=0;
7      while(r<s.length()){
8        if(hash[s.charAt(r)]!=-1){
9            if(hash[s.charAt(r)]>=l){
10                l=hash[s.charAt(r)]+1;
11            }
12        }
13        hash[s.charAt(r)]=r;
14        maxlen=Math.max(maxlen,r-l+1);
15        r++;
16      }
17      return maxlen;
18    }
19}