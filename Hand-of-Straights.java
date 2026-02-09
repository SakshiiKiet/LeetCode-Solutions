1class Solution {
2    public boolean isNStraightHand(int[] hand, int groupSize) {
3        // If total cards can't be divided evenly, return false
4        if(hand.length%groupSize!=0) return false;
5
6        // Store the frequency of each card
7        TreeMap<Integer,Integer>freq=new TreeMap<>();
8       for(int i=0;i<hand.length;i++){
9        freq.put(hand[i],freq.getOrDefault(hand[i],0)+1);
10       }
11       while(!freq.isEmpty()){
12        int curr=freq.firstKey();
13        for(int i=0;i<groupSize;i++){
14            //curr+i=curr,curr+1,curr+2;
15             if (!freq.containsKey(curr+i)) {
16                    return false;
17                }
18
19                freq.put((curr+i), freq.get(curr+i) - 1);
20
21                if (freq.get(curr+i) == 0) {
22                    freq.remove(curr+i);
23                }
24        }
25       }
26      return true;
27    }
28}