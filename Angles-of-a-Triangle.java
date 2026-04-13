1class Solution {
2    public double[] internalAngles(int[] sides) {
3        Arrays.sort(sides);
4        int a=sides[0];
5        int b=sides[1];
6        int c=sides[2];
7        if(a+b<=c){
8            return new double[]{};
9        }
10        double A=Math.toDegrees(Math.acos((b*b+c*c-a*a)/(2.0*b*c)));
11        double B=Math.toDegrees(Math.acos((a*a+c*c-b*b)/(2.0*a*c)));
12        double C=Math.toDegrees(Math.acos((a*a+b*b-c*c)/(2.0*a*b)));
13        double[] ans={A,B,C};
14        Arrays.sort(ans);
15        return ans;
16    }
17}