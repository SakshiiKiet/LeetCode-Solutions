1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3       int l=0,maxlen=0;
4       HashSet<Character>set=new HashSet<>();
5       for(int r=0;r<s.length();r++){
6          while(set.contains(s.charAt(r))){
7            set.remove(s.charAt(l));
8            l++;
9          }
10
11          set.add(s.charAt(r));
12          maxlen=Math.max(maxlen,r-l+1);
13       }
14       return maxlen;
15    }
16}