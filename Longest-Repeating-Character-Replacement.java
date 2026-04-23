1class Solution {
2    public int characterReplacement(String s, int k) {
3        int[] fre=new int[26];
4        int l = 0;
5        int maxcount=0;
6        int maxlength = 0;
7
8        for (int r = 0; r < s.length(); r++) {
9            fre[s.charAt(r)-'A']++;
10            maxcount=Math.max(maxcount, fre[s.charAt(r)-'A']);
11
12            if ((r-l+1)-maxcount> k) {
13                fre[s.charAt(l)-'A']--;
14                l++;
15            }
16           int c=r - l + 1;
17            maxlength = Math.max(maxlength, c);
18        }
19
20        return maxlength;
21    }
22}