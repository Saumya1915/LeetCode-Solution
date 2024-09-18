class Solution {
    class Pair{

        int node;
        int weight;

        Pair(int node,int weight){

                this.node=node;
                this.weight=weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
       PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.weight-b.weight);

       List<List<Pair>>adj=new ArrayList<>();
       for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
       }

       for(int i=0;i<times.length;i++){

            int x=times[i][0];
            int y=times[i][1];
            int z=times[i][2];

            adj.get(x).add(new Pair(y,z));
       }
        int visited[]=new int[n+1];
        Arrays.fill(visited,(int)(1e9));
        visited[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty())
        {
          Pair p=pq.remove();
          int node=p.node;
          int weight=p.weight;

          for(Pair it:adj.get(node)){
             int w=it.weight;
             int value=it.node;

             if(visited[value]>weight+w){
                visited[value]=weight+w;
                pq.add(new Pair(value,weight+w));
             }
          }
        }
          int maxi=-1;
          for(int i=1;i<=n;i++){
            if(visited[i]==(int)(1e9)){
                return -1;
            }
            else{
                maxi=Math.max(maxi,visited[i]);
            }
          }
          return maxi;
        


    }
}