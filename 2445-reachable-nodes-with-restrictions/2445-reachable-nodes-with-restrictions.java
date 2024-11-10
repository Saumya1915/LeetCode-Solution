class Solution {
    int sum=1;

    public void dfs(int start, ArrayList<ArrayList<Integer>>list,HashSet<Integer>set,int visited[]){

        visited[start]=1;
        for(Integer num:list.get(start)){

            if(visited[num]!=1 && !set.contains(num)){
                sum++;
                dfs(num,list,set,visited);
            }
        }



    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {

            int x=edges[i][0];
            int y=edges[i][1];
            list.get(x).add(y);
            list.get(y).add(x);
        }

        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<restricted.length;i++){
            set.add(restricted[i]);
        }

        dfs(0,list,set,new int[n]);
        return sum;
        
    }
}