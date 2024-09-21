class Solution {
    class Pair{

        int node;
        long time;

        Pair(int node,long time){

            this.node=node;
            this.time=time;
        }
    }
    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){

            int x=roads[i][0];
            int y=roads[i][1];
            int z=roads[i][2];


            adj.get(x).add(new Pair(y,z));
            adj.get(y).add(new Pair(x,z));
        }
        
        long ans[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(ans,Long.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.time,b.time));
        pq.add(new Pair(0,0));
        ans[0]=0;
        ways[0]=1;

        while(!pq.isEmpty())
        {
          
          Pair p=pq.remove();
          int node=p.node;
          long time=p.time;

          for(Pair it:adj.get(node)){

            int nt=it.node;
            long t=it.time;

            if(t+time<ans[nt]){
                ans[nt]=t+time;
                ways[nt]=ways[node];
                pq.add(new Pair(nt,t+time));
            }
            else if(t+time==ans[nt]){

                ways[nt]=(ways[node]+ways[nt])%1000000007;
            }
          }

          


        }
        return ways[n-1];

    }
}