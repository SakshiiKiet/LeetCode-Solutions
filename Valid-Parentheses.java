1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character>st=new Stack<>();
4        for(int i=0;i<s.length();i++){
5            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
6                st.push(s.charAt(i));
7            }else{
8                if(st.isEmpty()) return false;
9                char top=st.pop();
10                if(s.charAt(i)==')' && top!='(' ||
11                  s.charAt(i)=='}' && top!='{' ||
12                  s.charAt(i)==']' && top!='['){
13                    return false;
14                  }
15            }
16        }
17        return st.isEmpty();
18    }
19}