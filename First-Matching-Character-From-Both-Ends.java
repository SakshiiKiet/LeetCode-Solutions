1class Solution {
2    public int firstMatchingIndex(String s) {
3       for(int i=0;i<s.length();i++){
4           if(s.charAt(i)==s.charAt(s.length()-i-1)){
5               return i;
6           }
7       }
8        return -1;
9    }
10}