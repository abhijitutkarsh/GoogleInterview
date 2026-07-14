class Solution {
    public long maxPoints(int[][] points) {
        
        long dp[] = new long[points[0].length];

        for(int i = 0 ; i< points[0].length; i++)
        {
            dp[i] = points[0][i];

        }

        
            long[] dpLeft = new long[points[0].length];
            long[] dpRight = new long[points[0].length];

        for(int i =1 ; i< points.length ; i++)
        {
            dpLeft[0] = dp[0];
            dpRight[points[0].length-1] = dp[points[0].length -1];

            for(int j = 1 ; j < points[0].length ; j++)
            {
               dpLeft[j] = Math.max(dpLeft[j-1] -1, dp[j] );
            }

            for(int j=points[0].length-2; j>=0 ; j--)
            {
                dpRight[j] = Math.max(dpRight[j+1] -1, dp[j]);
            }

            for(int k = 0 ; k< points[0].length; k++)
            {
                dp[k] = points[i][k] + Math.max(dpLeft[k], dpRight[k]);
            }
        }

        long sol = 0;

        for(int i = 0; i< points[0].length; i++)
        {
            sol = Math.max(sol, dp[i]);
        }
        System.out.println("values" + Arrays.toString(dp));
        return sol;
    }
}