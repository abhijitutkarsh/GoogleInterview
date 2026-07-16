class Solution {
    public boolean canTransform(String start, String result) {
        
        int n = start.length();
        int m = result.length();
        int i =0, j = 0;
        while(i< n || j <m )
        {

            while(i<n && start.charAt(i) == 'X')
            {
                if(i<n)
                i++;
            }


            while(j<m && result.charAt(j) == 'X')
            {
                if(j<m)
                j++;
            }

            if(i == n && j== m) return true;
            if(i == n || j ==m) return false;

            if(start.charAt(i) != result.charAt(j))
            return false;

            if( start.charAt(i) == 'L' && start.charAt(i) == result.charAt(j) && i < j)
            return false;
  if( start.charAt(i) == 'R' && start.charAt(i) == result.charAt(j) && i > j)
            return false;



            i++;
            j++;
        }

        return true;
    }
}