1class Solution {
2
3    public List<List<Integer>> permute(int[] nums) {
4       List<List<Integer>>ans=new ArrayList<>();
5       boolean[] freq=new boolean[nums.length];
6       permutation(nums,ans,new ArrayList<>(),freq);
7       return ans;
8
9    }
10    void permutation(int[] nums,List<List<Integer>>ans,List<Integer>ds,boolean[] freq){
11        if(ds.size()==nums.length){
12            ans.add(new ArrayList<>(ds));
13            return;
14        }
15        for(int i=0;i<nums.length;i++){
16            if(freq[i]==false){
17                freq[i]=true;;
18                ds.add(nums[i]);
19                permutation(nums,ans,ds,freq);
20                ds.remove(ds.size()-1);
21                freq[i]=false;
22            }
23        }
24    }
25}
26