class Solution {
    class Pair{
        int v;
        int wt;
        int dist;
        
        Pair(int v, int wt, int dist){
            this.v = v;
            this.wt = wt;
            this.dist = dist;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : flights){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            graph.get(u).add(new Pair(v, wt, 0));
            
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);

        pq.add(new Pair(src,0,-1));
         int[] stop = new int[n];
        Arrays.fill(stop, Integer.MAX_VALUE);

        while(!pq.isEmpty())
        {
            Pair p=pq.remove();

            if(p.v==dst)
            {
                return p.wt;
            }

            for(Pair it:graph.get(p.v)){

                if(p.dist+1<=k && stop[it.v]> p.dist){
                    pq.add(new Pair(it.v,p.wt+it.wt,p.dist+1));
                    stop[p.v] = p.dist;
                }
            }
        }
        return -1;
    }
}