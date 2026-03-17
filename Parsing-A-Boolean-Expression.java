1class Solution {
2    public boolean parseBoolExpr(String expression) {
3
4        Stack<Character> st = new Stack<>();
5
6        for (char ch : expression.toCharArray()) {
7
8            if (ch == ',' ) continue;
9
10            if (ch != ')') {
11                st.push(ch);
12            } else {
13
14                boolean hasTrue = false;
15                boolean hasFalse = false;
16
17                while (st.peek() != '(') {
18                    char val = st.pop();
19                    if (val == 't') hasTrue = true;
20                    if (val == 'f') hasFalse = true;
21                }
22
23                st.pop(); // remove '('
24                char op = st.pop();
25
26                char res;
27
28                if (op == '!') {
29                    res = hasTrue ? 'f' : 't';
30                }
31                else if (op == '&') {
32                    res = hasFalse ? 'f' : 't';
33                }
34                else { // '|'
35                    res = hasTrue ? 't' : 'f';
36                }
37
38                st.push(res);
39            }
40        }
41
42        return st.peek() == 't';
43    }
44}