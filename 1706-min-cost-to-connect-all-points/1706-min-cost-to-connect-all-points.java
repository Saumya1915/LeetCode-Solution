class Solution {
    class Pair{

        int num;
        int weight;

        Pair(int num, int weight){

            this.num=num;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>>list=new ArrayList<>();
        for(int i=0;i<points.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                 int x=Math.abs(points[i][0]-points[j][0]);
                 int y=Math.abs(points[i][1]-points[j][1]);
                 int sum1=x+y;
                 //System.out.println(i+"---->"+sum1);
                 list.get(i).add(new Pair(j,sum1));
                 list.get(j).add(new Pair(i,sum1));



            }
        }
        HashMap<Integer,Boolean>map=new HashMap<>();
        int sum=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.weight-b.weight));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair p=pq.remove();
            int weight=p.weight;
            int node=p.num;
            //System.out.println(node+" "+weight);
            if(map.containsKey(node)){
                continue;
            }
            if(!map.containsKey(node)){
                map.put(node,true);
                sum+=weight;
            }
            for(Pair pair:list.get(node)){
                if(!map.containsKey(pair.num)){
                    pq.add(new Pair(pair.num,pair.weight));
                }
            }
        }
        return sum;
    }
}