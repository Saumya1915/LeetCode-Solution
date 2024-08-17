class Solution {
    class Pair{
        
        int stop;
        int city;
        int cost;
        
        Pair(int stop,int city,int cost){
            this.stop=stop;
            this.city=city;
            this.cost=cost;
            
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
         for(int i=0;i<flights.length;i++){
            int from=flights[i][0];
            int to=flights[i][1];
            int cost=flights[i][2];
            
            adj.get(from).add(new Pair(0,to,cost));
            
        }
        
       int price[]=new int[n];
        Arrays.fill(price,(int)(1e9));
        price[src]=0;
        
        Queue<Pair> pq=new LinkedList<>();
        pq.add(new Pair(0,src,0));
        while(!pq.isEmpty())
        {
            Pair p=pq.remove();
            int cost=p.cost;
            int city=p.city;
            int stop=p.stop;
            
            for(int it=0; it<adj.get(city).size();it++){
                int cos=adj.get(city).get(it).cost;
                int ci=adj.get(city).get(it).city;
                if(stop<=k)
                {
                    if(price[ci]>cost+cos)
                    {
                        price[ci]=cost+cos;
                        pq.add(new Pair(stop+1,ci,price[ci]));
                        //System.out.print(cost+" "+cos);
                        
                    }
                    //System.out.println();
                    
                }
                /*for(int i=0;i<n;i++){
                    System.out.print(price[i]+" ");
                }
                System.out.println();*/
                
            }
        }
        if(price[dst]==(int)(1e9)){
            return -1;
        }
        return price[dst];
}
}