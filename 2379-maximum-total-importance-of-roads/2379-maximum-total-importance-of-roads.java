class Solution {
    class Pair{

        int num;
        int size;

        Pair(int num,int size){
            this.num=num;
            this.size=size;
        }
    }
    public long maximumImportance(int n, int[][] roads) {
       ArrayList<ArrayList<Integer>>list=new ArrayList<>();
       for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
       }
       for(int i=0;i<roads.length;i++){

            int x=roads[i][0];
            int y=roads[i][1];
            list.get(x).add(y);
            list.get(y).add(x);

       }
       PriorityQueue<Pair> p=new PriorityQueue<>((a,b)->(b.size-a.size));
    
       for(int i=0;i<list.size();i++){
          int size=list.get(i).size();
          p.add(new Pair(i,size));
       }

       HashMap<Integer,Integer> map=new HashMap<>();

       for(int i=n;i>0;i--){
         Pair pq=p.remove();
         map.put(pq.num,i);
       }
    
       long sum=0;
       for(int i=0;i<roads.length;i++){
            sum+=map.get(roads[i][0]);
            sum+=map.get(roads[i][1]);
       }
       return sum;

    }
}