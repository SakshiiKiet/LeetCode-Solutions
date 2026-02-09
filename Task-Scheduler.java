1class Solution {
2    public int leastInterval(char[] tasks, int n) {
3        int[] arr=new int[26];
4        for(int i=0;i<tasks.length;i++){
5            arr[tasks[i]-'A']++;
6        }
7        int time=0;
8        PriorityQueue<Integer>p=new PriorityQueue<>((a, b) -> b - a);
9        for(int i=0;i<arr.length;i++){
10            if(arr[i]>0){
11               p.add(arr[i]);
12            }
13        }
14        while(!p.isEmpty()){
15            List<Integer>temp=new ArrayList<Integer>();
16            for(int i=1;i<=n+1;i++){
17                if(!p.isEmpty()){
18                    int freq=p.poll();
19                    freq--;
20                    temp.add(freq);
21                }
22            }
23            for(int i=0;i<temp.size();i++){
24                if(temp.get(i)>0){
25                    p.add(temp.get(i));
26                }
27            }
28            if(p.isEmpty()){
29                time+=temp.size(); // at last when no freg left to put in p(heap)
30            }else{
31                time+=n+1;
32            }
33        }
34        return time;
35    }
36}