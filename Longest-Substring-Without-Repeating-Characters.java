1class Solution {
2    public int lengthOfLongestSubstring(String s) {
3        int maxlen=0;
4        for(int i=0;i<s.length();i++){
5            String subs="";
6            for(int j=i;j<s.length();j++){
7               if(subs.indexOf(s.charAt(j))!=-1){
8                break;
9               }
10               subs+=s.charAt(j);
11               maxlen=Math.max(maxlen,subs.length());
12            }
13        }
14        return maxlen;
15    }
16}