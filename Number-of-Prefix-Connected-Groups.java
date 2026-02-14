1class Solution {
2    public int prefixConnected(String[] words, int k) {
3        HashMap<String,Integer>map=new HashMap<>();
4        for(String i:words){
5            if(i.length()>=k){
6                String p=i.substring(0,k);
7            map.put(p,map.getOrDefault(p,0)+1);
8            }
9        }
10        int c=0;
11        for(int i:map.values()){
12            if(i>=2){
13                c++;
14            }
15        }
16        return c;
17    }
18}