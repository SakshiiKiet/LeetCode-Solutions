1class Solution {
2    public int longestPalindrome(String s) {
3        HashMap<Character,Integer>map=new HashMap<>();
4         for(int i = 0; i < s.length(); i++) {
5            char ch = s.charAt(i);
6            map.put(ch, map.getOrDefault(ch, 0) + 1);
7        }
8        int length=0;
9        boolean odd=false;
10
11        for(int f:map.values()){
12            length+=(f/2)*2;
13            if(f%2==1){
14                odd=true;
15            }
16        }
17        if(odd==true) length++;
18        return length;
19    }
20}