1class Solution {
2    public int numberOfSubstrings(String s) {
3       int c=0;
4       for(int i=0;i<s.length();i++){
5        int[] hash=new int[3];
6        for(int j=i;j<s.length();j++){
7            hash[s.charAt(j)-'a']=1;
8            if(hash[0]+hash[1]+hash[2]==3){
9                c+=1;
10            }
11        }
12       }
13       return c;
14    }
15}