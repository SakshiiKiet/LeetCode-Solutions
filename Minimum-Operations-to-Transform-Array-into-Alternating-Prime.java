1class Solution {
2    public int minOperations(int[] nums) {
3        int c=0;
4        for(int i=0;i<nums.length;i++){
5            if(i%2==0 && isPrime(nums[i])==false){
6                int s1=0;
7                while(isPrime(nums[i])==false){
8                    nums[i]++;
9                    s1++;
10                }
11                c+=s1;
12            }else if(i%2!=0 && isPrime(nums[i])==true){
13                int s1=0;
14                while(isPrime(nums[i])==true){
15                    nums[i]++;
16                    s1++;
17                }
18                c+=s1;
19            }
20        }
21            return c;
22        }
23    boolean isPrime(int n){
24        if(n<=1) return false;
25        if(n==2) return true;
26        for(int i=2;i*i<=n;i++){
27            if(n%i==0){
28                return false;
29            }
30        }
31        return true;
32    }    
33}