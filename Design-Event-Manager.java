1class EventManager {
2    HashMap<Integer,Integer>map;
3    PriorityQueue<int[]>p;
4    public EventManager(int[][] events) {
5        map=new HashMap<>();
6        p=new PriorityQueue<>((a,b)->{
7        if (b[1] != a[1]) return b[1] - a[1]; // higher priority first
8        return a[0] - b[0]; // smaller eventId first
9        });
10        for(int i=0;i<events.length;i++){
11            int id=events[i][0];
12            int prio=events[i][1];
13            map.put(id,prio);
14            p.add(new int[]{id,prio});
15        }
16    }
17    
18    public void updatePriority(int eventId, int newPriority) {
19        // update latest prio in map,  map contains only latest value
20        map.put(eventId,newPriority);
21        //push new entry in heap
22        p.add(new int[]{eventId,newPriority});
23    }
24    
25    public int pollHighest() {
26        while(!p.isEmpty()){
27            int[] top=p.peek();
28            int id=top[0];
29            int prio=top[1];
30            
31            // check if this entry is still valid
32            if (map.containsKey(id) && map.get(id) == prio) {
33                p.poll();        // remove from heap
34                map.remove(id);   // mark as inactive
35                return id;
36            }
37
38            // outdated entry → discard
39            p.poll();
40
41        }
42        return -1;
43    }
44}
45
46/**
47 * Your EventManager object will be instantiated and called as such:
48 * EventManager obj = new EventManager(events);
49 * obj.updatePriority(eventId,newPriority);
50 * int param_2 = obj.pollHighest();
51 */