class Solution {
    int rank[];
    int parent[];
    public int findParent(int u)
    {
        if(u==parent[u]){
            return u;
        }
        return parent[u]=findParent(parent[u]);
    }
    public int makeConnected(int n, int[][] connections) {
        rank=new int[n];
        parent=new int[n];

        if(connections.length<n-1){
            return -1;
        }
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int count=0;
        for(int i=0;i<connections.length;i++){
           
           int x=connections[i][0];
           int y=connections[i][1];
           
           list.get(x).add(y);
           count++;
            
        }
        for(int i=0;i<n;i++)
        {
            for(Integer it:list.get(i)){
                int pv=findParent(it);
                int pu=findParent(i);
                System.out.println(i+"--->"+pu+" "+it+"-->"+pv);
                if(pu!=pv)
                {
                if(rank[pu]>rank[pv]){
                    parent[pv]=pu;
                }
                else if(rank[pv]>rank[pu]){
                    parent[pu]=pv;
                }
                else{
                    parent[pu]=pv;
                    rank[pv]++;
                }
                count--;}


            }
        }

        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<n;i++){
            if(parent[i]==i){
            set.add(parent[i]);}
            
        }
        System.out.println(count+" "+set.size());
        if(set.size()==1){
            return 0;
        }
        if(count>=set.size()-1){
            return set.size()-1;
        }
        return -1;




    }
}