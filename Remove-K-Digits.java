1class Solution {
2    public String removeKdigits(String num, int k) {
3        int n=num.length();
4        Stack<Character>st=new Stack<>();
5        for(int i=0;i<n;i++){
6            while(!st.isEmpty() && k>0 && num.charAt(i)<st.peek()){
7                st.pop();
8                k--;
9            }
10            st.push(num.charAt(i));
11        }
12        while(k>0){
13            st.pop();
14            k--;
15        }
16        
17        StringBuilder sb=new StringBuilder();
18         while(!st.isEmpty()){
19            sb.append(st.pop());
20         }
21         sb.reverse();
22         while(sb.length()>1 && sb.charAt(0)=='0'){
23            sb.deleteCharAt(0);
24         }
25         if(sb.length()==0) return "0";
26         return sb.toString();
27    }
28}