class Solution {

    private void log(String s)
    {
        System.out.println(s);
    }

    public int findMinDifference(List<String> timePoints) {
        
        // create store for minutes
        int n = timePoints.size();
        int [] minutes = new int[n];

        //Put the updated value to the store
        for(int i =0 ; i< timePoints.size(); i++)
        {
            int hour = Integer.parseInt(timePoints.get(i).substring(0,2));
            int hourMin = hour * 60;

            int minutesLast = Integer.parseInt(timePoints.get(i).substring(3,5));

            minutes[i] = hourMin + minutesLast;
        }

        //sorting it and check whether min for both ways around
        Arrays.sort(minutes);
        log("Checking Minutes Array " +Arrays.toString(minutes));
        int minFinal = Integer.MAX_VALUE;
        int _24Hour = 24 *60;
        for(int i = 1  ; i< minutes.length; i++)
        {
int minBoth = minutes[i] - minutes[i-1];
        
            minFinal = Integer.min(minFinal, minBoth);

        }
                    log("checking min " + minFinal);

    int last24 = _24Hour - minutes[n-1];
 
    int last = Math.abs(last24 + minutes[0]);
    log("checkingLast24 and last "+ last + " " + last24);
minFinal = Integer.min(minFinal, last);
        // final answer
        return minFinal;
    }
}

