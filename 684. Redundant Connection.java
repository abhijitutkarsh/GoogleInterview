class Solution {
    //Initializing the store
        int [] parent;

        private int find( int node)
        {
          if(parent[node] == node)
          {
            return node;
          }
          parent[node] = find(parent[node]);

          return parent[node];
        }

    private boolean unionCheck(int node1,int node2)
    {
        int ultimate1 = find(node1);
        int ultimate2 = find(node2);

        if(ultimate1 == ultimate2) return false;

        parent[ultimate1] = ultimate2;

        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n+1];

        //Make every one there own boss
        for(int i = 1 ; i <= n ; i++ )
        {
            parent[i] = i;
        }

        for(int i = 0 ; i< n ; i++)
        {
            int node1 = edges[i][0];
            int node2 = edges[i][1];

            if(!unionCheck(node1, node2))
            {
                return edges[i];
            }

        }
        return new int[]{};
    }
}