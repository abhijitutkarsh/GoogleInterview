//using dijkstra's algorithm

class Solution {
    public int swimInWater(int[][] grid) {
        
        //intializing the storing states
        int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{0,1},{1,0},{-1,0}, {0,-1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean [][] visited = new boolean[n][m];
        // Arrays.fill(visited, false); // not necessary 

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Loop and exit Strategy
        while(!pq.isEmpty())
        {
            int[] currentPoint = pq.poll();

            int currentTime = currentPoint[0];
            int currenti = currentPoint[1];
            int currentj = currentPoint[2];

            if(currenti == n-1 && currentj == m-1)
            return currentTime;

        //Scan and filter neighbors
            int checkMaxCurrent = 0;
            int nPointi = 0;
            int nPointj = 0;
            for(int i=0 ; i< directions.length; i++)
            {
                checkMaxCurrent = currentTime;
                nPointi = currenti + directions[i][0];
                nPointj = currentj + directions[i][1];

                if(nPointi < 0 || nPointi >= n || nPointj <0 || nPointj >= m || visited[nPointi][nPointj] == true )
                continue;

        //the water level math and queue updates
                checkMaxCurrent = Integer.max(checkMaxCurrent, grid[nPointi][nPointj]);
                visited[nPointi][nPointj] = true;
                pq.offer(new int[] {checkMaxCurrent,nPointi , nPointj} );
            }
            

        }

        return  -1;
        
    }
}


///////// using union find
class Solution {
    //DSU Template

    boolean debug = true;

    private void log(String msg)
    {
        if(debug)
        System.out.println(msg);
    }

    int [] parent;
    private int find(int node)
    {
      if(parent[node] == node)
      return node;

      parent[node] = find(parent[node]);

      return parent[node];
    }

    private void union(int node1, int node2)
    {
        int parenti = find(node1);
        int parentj = find(node2);

        if(parenti == parentj) 
        {
            return ;
        }
        
        parent[parenti] = parentj;
       return ;
    }

    // 1 D Translators

    private int[] _1Dto2d(int id, int n)
    {
        int i = id/n;
        int j = id%n;

        return new int[]{i,j};
    }

    private int _2Dto1d(int i,int j, int n )
    {
        return (i*n)+j;     
    }


    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // defining parent
        parent = new int[n*n];

        for(int i = 0 ; i< n*m ;i++)
        {
            parent[i] = i;
        }

        //Precomputation
        int [] timeToLocation = new int[n*n];
        
        for(int i = 0 ; i< grid.length; i++)
        {
            for(int j = 0 ; j< grid[0].length; j++)
            {
                timeToLocation[grid[i][j]] = _2Dto1d(i,j,n);
            }
        }
        System.out.println("timeToLocation" + Arrays.toString(timeToLocation));
        //Simulation and merge loop
        int [][] directions = {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        for(int t = 0 ; t< n*n ; t++)
        {
            log("testing " + t);
            int current_id = timeToLocation[t];
            int[] current_coordinates = _1Dto2d(current_id, n);
            
            int currenti = current_coordinates[0];
            int currentj = current_coordinates[1];
        System.out.println("current position" + Arrays.toString(new int[]{currenti, currentj}));

            for(int i = 0 ; i< directions.length; i++)
            {
                int nexti = currenti + directions[i][0];
                int nextj = currentj + directions[i][1];
                 if( nexti >= 0 && nexti <n && 
                    nextj >=0 && nextj < m )
System.out.println("check direction " + t + " " + grid[currenti][currentj] + " " + grid[nexti][nextj]); 
                
                if( nexti >= 0 && nexti <n && 
                    nextj >=0 && nextj < m &&
                    grid[currenti][currentj] >= grid[nexti][nextj])
                {
                int next_id = timeToLocation[grid[nexti][nextj]];
                    union(current_id, next_id);
        System.out.println("time union" + t + " " + grid[currenti][currentj] + " " + grid[nexti][nextj]); 

                }
            }

        //The winning condition

        //   System.out.println("parent for " + grid); 
        
            if(find(timeToLocation[grid[0][0]]) == find(timeToLocation[grid[n-1][n-1]]))
            {
                
                return t;
                
            }

        }
    return -1;
        
    }
}