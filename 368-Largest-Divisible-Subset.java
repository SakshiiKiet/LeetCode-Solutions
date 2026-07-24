class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int last=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }
        List<Integer>list=new ArrayList<>();
        list.add(nums[last]);
        while(hash[last]!=last){
            last=hash[last];
            list.add(nums[last]);
        }
        Collections.reverse(list);
        return list;
    }
}