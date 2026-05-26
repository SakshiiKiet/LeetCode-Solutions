1class Solution {
2    public int majorityElement(int[] nums) {
3        int c=0;
4        int el=0;
5        for(int i=0;i<nums.length;i++){
6            if(c==0){
7                c=1;
8                el=nums[i];
9            }else if(nums[i]==el){
10                c++;
11            }else{
12                c--;
13            }
14        }
15        int c2=0;
16        for(int i=0;i<nums.length;i++){
17            if(nums[i]==el){
18                c2++;
19            }
20            if(c2>nums.length/2){
21                return el;
22            }
23        }
24        return -1;
25    }
26}