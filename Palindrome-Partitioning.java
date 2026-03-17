1class Solution {
2    public List<List<String>> partition(String s) {
3       List<List<String>>res=new ArrayList<>();
4       List<String>path=new ArrayList<>();
5       func(s,0,res,path);
6       return res;
7
8    }
9    void func(String s,int index,List<List<String>>res,List<String>path){
10        if(index==s.length()){
11            res.add(new ArrayList<>(path));
12            return;
13        }
14        for(int i=index;i<s.length();i++){
15            if(isPallindrome(s,index,i)){
16              path.add(s.substring(index,i+1));
17              func(s,i+1,res,path);
18              path.remove(path.size()-1);
19            }
20        }
21    }
22    boolean isPallindrome(String s,int start,int end){
23        while(start<=end){
24            if(s.charAt(start++)!=s.charAt(end--)){
25                return false;
26            }
27        }
28        return true;
29    }
30}