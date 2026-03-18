1class Solution {
2    public boolean checkValidString(String s) {
3        int n = s.length();
4        int min=0,max=0;
5        for(int i=0;i<n;i++){
6            if(s.charAt(i)=='('){
7                min=min+1;
8                max=max+1;
9            }else if(s.charAt(i)==')'){
10                min=min-1;
11                max=max-1;
12            }else{
13                min=min-1;
14                max=max+1;
15            }
16            if(min<0) min=0;
17            if(max<0){
18                return false;
19            }
20        }
21        return min==0;
22    }
23}