1class Solution {
2    public String trimTrailingVowels(String s) {
3        StringBuilder sb=new StringBuilder(s);
4        for(int i=sb.length()-1;i>=0;i--){
5            if(sb.charAt(i)=='a' || sb.charAt(i)=='e'|| sb.charAt(i)=='i' || sb.charAt(i)=='o'|| sb.charAt(i)=='u'){
6                sb.deleteCharAt(i);
7            }else{
8                break;
9            }
10        }
11        return sb.toString();
12    }
13}