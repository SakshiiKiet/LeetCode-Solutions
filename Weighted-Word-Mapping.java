1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3    StringBuilder st=new StringBuilder();
4       for(int i=0;i<words.length;i++){
5           int s=0;
6           for(int j=0;j<words[i].length();j++){
7               s+=weights[words[i].charAt(j)-'a'];
8           }
9           char map=(char) ('z'-(s%26));
10           st.append(map);
11       }
12        return st.toString();
13    }
14}