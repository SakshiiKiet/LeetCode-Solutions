1class Solution {
2
3    public List<List<String>> partition(String s) {
4        List<List<String>> res = new ArrayList<>();
5        List<String> path = new ArrayList<>();
6        func(0, s, path, res);
7        return res;
8    }
9
10    void func(int index, String s, List<String> path, List<List<String>> res) {
11
12        if (index == s.length()) {
13            res.add(new ArrayList<>(path));
14            return;
15        }
16
17        for (int i = index; i < s.length(); i++) {
18            if (isPalindrome(s, index, i)) {
19
20                path.add(s.substring(index, i + 1));
21                func(i + 1, s, path, res);
22                path.remove(path.size() - 1); // backtrack
23            }
24        }
25    }
26
27    boolean isPalindrome(String s, int start, int end) {
28        while (start <= end) {
29            if (s.charAt(start++) != s.charAt(end--)) {
30                return false;
31            }
32        }
33        return true;
34    }
35}