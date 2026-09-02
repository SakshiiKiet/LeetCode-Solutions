class Solution {

    int[] arr;

    public int climbStairs(int n) {

        arr = new int[n + 1];
        Arrays.fill(arr, -1);

        return solve(n);
    }

    int solve(int n) {

        if(n <= 1) {
            return 1;
        }

        if(arr[n] != -1) {
            return arr[n];
        }

        arr[n] = solve(n - 1) + solve(n - 2);

        return arr[n];
    }
}