1class Solution {
2    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
3        TreeMap<Integer,Integer>map=new TreeMap<>();
4        for(int bulb:bulbs){
5            map.put(bulb,map.getOrDefault(bulb,0)+1);
6        }
7        List<Integer>ans=new ArrayList<>();
8        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
9            if(entry.getValue()%2!=0){
10                ans.add(entry.getKey());
11            }
12        }
13        return ans;
14    }
15}