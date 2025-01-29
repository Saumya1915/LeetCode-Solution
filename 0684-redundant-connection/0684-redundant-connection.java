class Solution {
    int rank[];
    int parent[];

    public int findParent(int num){
        if(parent[num]==num){
            return num;
        }
        return parent[num]=findParent(parent[num]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int ans[]=new int[2];
        rank=new int[edges.length+1];
        parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            int parentu=findParent(u);
            int parentv=findParent(v);

            if(parentu==parentv){
                ans=edges[i];
                continue;
            }
            else if(rank[parentu]>rank[parentv]){
                parent[parentv]=parentu;
            }
            else if(rank[parentu]<rank[parentv]){
                parent[parentu]=parentv;
            }
            else{
               parent[parentu]=parentv;
               rank[parentv]++; 
            }

        }
        return ans;


        
    }
}