class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

// creating the adjacency List
        Map<Integer, List<int []>> adjList = new HashMap<>();


        for(int[] i: times)
        {
            adjList.putIfAbsent(i[0], new ArrayList<>());
            adjList.get(i[0]).add(new int[]{i[1], i[2]});
        }
//Set up the best score tracker

        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        minTime[k] = 0;

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        pq.offer( new int[]{0,k});
    
    //Dijstra's Engine

        while(!pq.isEmpty())
        {
            int[] current = pq.poll();

            int currentTime = current[0];
            int currentNode = current[1];

            //Stale Path check
            if(currentTime > minTime[currentNode])
            continue;

            List<int[]> theList = adjList.getOrDefault(currentNode, new ArrayList<>());

            for(int[] neighbor: theList)
            {
                int arrivalTime = currentTime + neighbor[1];
                if(minTime[neighbor[0]] > arrivalTime)
                {
                    minTime[neighbor[0]] = arrivalTime;
                    pq.offer(new int[]{arrivalTime,neighbor[0]});
                }
            }
        }

        int result = 0;
        for(int allmins = 1; allmins< minTime.length; allmins++)
        {
            if(minTime[allmins] == INTEGER.MAX_VALUE)
            return -1;
            result = Math.max(result, minTime[allmins]);
        }

        return result;

    }
}