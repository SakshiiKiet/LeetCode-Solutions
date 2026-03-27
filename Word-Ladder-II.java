1class Solution {
2    
3    String b;
4    HashMap<String, Integer> mpp;
5    List<List<String>> ans;
6
7    public void dfs(String word, List<String> seq) {
8        
9        if (word.equals(b)) {
10            // Since Java works with reference, create
11            // a duplicate and store the reverse of it
12            List<String> dup = new ArrayList<>(seq);
13            Collections.reverse(dup);
14            ans.add(dup);
15            return;
16        }
17
18        int steps = mpp.get(word);
19        int sz = word.length();
20
21        for (int i = 0; i < sz; i++) {
22            for (char ch = 'a'; ch <= 'z'; ch++) {
23
24                char arr[] = word.toCharArray();
25                arr[i] = ch;
26
27                String newWord = new String(arr);
28
29                if (mpp.containsKey(newWord) && mpp.get(newWord) + 1 == steps) {
30                    seq.add(newWord);
31                    dfs(newWord, seq);
32                    seq.remove(seq.size() - 1);
33                }
34            }
35        }
36    }
37
38    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
39        
40        Set<String> st = new HashSet<>();
41        for (int i = 0; i < wordList.size(); i++) {
42            st.add(wordList.get(i));
43        }
44
45        Queue<String> q = new LinkedList<>();
46
47        // BFS starting from beginWord
48        q.add(beginWord);
49
50        mpp = new HashMap<>();
51        mpp.put(beginWord, 1);
52
53        int sz = beginWord.length();
54        st.remove(beginWord);
55
56        while (!q.isEmpty()) {
57            String word = q.peek();
58            int steps = mpp.get(word);
59            q.remove();
60
61            if (word.equals(endWord)) break;
62
63            for (int i = 0; i < sz; i++) {
64                for (char ch = 'a'; ch <= 'z'; ch++) {
65
66                    char arr[] = word.toCharArray();
67                    arr[i] = ch;
68
69                    String newWord = new String(arr);
70
71                    if (st.contains(newWord) == true) {
72                        q.add(newWord);
73                        st.remove(newWord);
74                        mpp.put(newWord, steps + 1);
75                    }
76                }
77            }
78        }
79
80        ans = new ArrayList<>();
81
82        // If endWord is reached
83        if (mpp.containsKey(endWord) == true) {
84            List<String> seq = new ArrayList<>();
85            seq.add(endWord);
86            b = beginWord;
87            dfs(endWord, seq);
88        }
89
90        return ans;
91    }
92}