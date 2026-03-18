1class Solution {
2    public boolean lemonadeChange(int[] bills) {
3        int n=bills.length;
4        int five=0,ten=0;
5        for(int i=0;i<n;i++){
6            if(bills[i]==5){
7                five+=1;
8            }else if(bills[i]==10){
9                if(five!=0){
10                    five-=1;
11                    ten+=1;
12                }else{
13                    return false;
14                }
15            }else{
16                if(ten!=0 && five!=0){
17                    five-=1;
18                    ten-=1;
19                }else if(five>=3){
20                    five-=3;
21                }else{
22                    return false;
23                }
24            }
25        }
26        return true;
27    }
28}