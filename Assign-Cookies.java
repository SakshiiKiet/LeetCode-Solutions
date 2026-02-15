1class Solution {
2    public int findContentChildren(int[] g, int[] s) {
3        Arrays.sort(g);
4        Arrays.sort(s);
5        int r=0,l=0;
6        while(r < g.length && l<s.length){
7            if(g[r]<=s[l]){
8                r++;
9            }
10            l++;
11        }
12        return r;
13    }
14}