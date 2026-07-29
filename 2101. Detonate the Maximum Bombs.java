class Solution {

    //BFS Logic

    private void log(String v)
    {
        System.out.println(v);
    }

    private int bfs(int a,Map<Integer, List<Integer>> mp, int n)
    {
        int count = 0;

        Queue<Integer>q = new LinkedList<>();
        boolean [] vis = new boolean[n];
        q.offer(a);
        vis[a] = true;
        while(!q.isEmpty())
        {
            int value = q.poll();
            count++;

            List<Integer> itr = mp.getOrDefault(value, new ArrayList<>());
            
            for(int i: itr)
            {
                if(!vis[i])
                {q.offer(i);
                vis[i] = true;
                }
            }
            
        }

        return count;
    }

    public int maximumDetonation(int[][] bombs) {
        
        //create an adjList 

        Map<Integer, List<Integer>> mp = new HashMap<>();

        //update the adjlist

        // int [] bomb1 = {100000,0, 10};
        // int [] bomb2 = {0,0, 10};



        for(int i = 0 ; i< bombs.length; i++)
        {
            for(int j = 0 ; j< bombs.length; j++)
            {
                // bombs[i] = bomb1;
                // bombs[j] = bomb2;
                if(i == j) continue;
        //Logic for distance calculation comparing with r1
                long edis = ((long)(bombs[i][0] - bombs[j][0] )* (long)(bombs[i][0] - bombs[j][0] )) + ((long)(bombs[i][1] - bombs[j][1] ) * (long)(bombs[i][1] - bombs[j][1] ));

                log("checking edis " + edis);

                if(edis <= (long)bombs[i][2] * bombs[i][2])
                {
                    mp.putIfAbsent(i , new ArrayList<>());
                    mp.get(i).add(j);
                }
            }
        }

System.out.println(mp);
    

        // Looping the bombs array and checking the one which has maximum value.
        int maximumArray = Integer.MIN_VALUE;
        for(int i = 0 ; i< bombs.length; i++)
        {
           
            maximumArray = Math.max(maximumArray, bfs(i,mp, bombs.length));
        }

        return maximumArray;
        
    }
}