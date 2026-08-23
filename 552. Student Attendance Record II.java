class Solution {
    public int checkRecord(int n) {
        //define the 6 states and modulo
        long dp[] = new long[6];

        int mod = 1000000007;
        //Initialize day 0
        dp[0] = 1;
        //The daily loop (The three actions)
        
        for(int i =0; i< n ; i++)
        {
            long[] next_dp = new long[6];

            //As As
            next_dp[0] = (dp[0] + dp[1] + dp[2]) % mod;
            next_dp[3] = (dp[3] + dp[4] +dp[5] + dp[0] +dp[1] + dp[2] )% mod;

            //As Ls

            next_dp[1] = dp[0];
            next_dp[2] = dp[1];

            next_dp[4] = dp[3];
            next_dp[5]= dp[4];

        dp = next_dp;
        }

        long totalSum = 0;
        for (long count : dp) {
            totalSum = (totalSum + count) % mod;
        }
        //Managing overflow
        return (int)totalSum;
        //Advance the daily and tally
    }
}