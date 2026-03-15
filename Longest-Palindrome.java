1import java.util.*;
2
3class Solution {
4    public int longestPalindrome(String s) {
5        
6        HashSet<Character> set = new HashSet<>();
7        int length = 0;
8        
9        for(char ch : s.toCharArray()) {
10            if(set.contains(ch)) {
11                set.remove(ch);
12                length += 2;   // pair formed
13            } else {
14                set.add(ch);
15            }
16        }
17        
18        // if any single character left → center
19        if(!set.isEmpty()) length++;
20        
21        return length;
22    }
23}