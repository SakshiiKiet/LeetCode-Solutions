1class Solution {
2    public boolean isHappy(int n) {
3        int slow=n;
4        int fast=n;
5     do{
6        slow=findsquare(slow);
7        fast=findsquare(findsquare(fast));
8     }while(slow!=fast);
9     if(slow==1){
10        return true;
11     }
12     return false;
13    }
14    private int findsquare(int number){
15        int ans=0;
16        while(number>0){
17            int rem=number%10;
18            ans+=rem*rem;
19            number/=10;
20        }
21        return ans;
22    }
23}