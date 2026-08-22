class Solution {
    public int maxProfit(int[] prices) {
        


//length prices
int n = prices.length;

        //get the last state of the array for max profit

        int [] buy = new int [n+1];
        int [] sell = new int [n+1];
        int [] cooldown = new int [n+1];

buy[0] = -prices[0];
sell[0] = 0;
cooldown[0] = 0;


        // traversing the array 
        for(int i = 1 ; i< prices.length ; i++)
        {

            buy[i] = Math.max(buy[i-1] , cooldown[i-1] - prices[i]);
            sell[i] = prices[i] + buy[i-1];
            cooldown[i] = Math.max(cooldown[i-1], sell[i-1]);


            // defining the logic
//   conditions are if 
//   we buy = max(buy[i-1], cooldown[i-1] - prices[i])
//   we sell = price[i] + buy[i-1] 
//   we cooldown = max(cooldown[i-1],sell[i-1] )

        }
        return Math.max(sell[n-1], cooldown[n-1]);
    }
}

