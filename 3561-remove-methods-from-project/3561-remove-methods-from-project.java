class Solution {
    public void dfs(int k,int visited[],ArrayList<ArrayList<Integer>>adj){
        visited[k]=1;

        for(Integer it:adj.get(k)){
            if(visited[it]==0){
                dfs(it,visited,adj);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        List<Integer>list=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<invocations.length;i++){

            int x=invocations[i][0];
            int y=invocations[i][1];

            adj.get(x).add(y);
        }
        int visited[]=new int[n];
        dfs(k,visited,adj);

    for(int i=0;i<n;i++){
        System.out.print(visited[i]+" ");
    }
        int count=0;
        
        for(int i=0;i<n;i++){
            if(visited[i]==1){
                count++;
            }
        }
        if(count==n){
            return new ArrayList<>();
        }
        boolean flag=true;
        for(int i=0;i<adj.size();i++){
            if(visited[i]==0)
            {
                for(Integer it:adj.get(i))
                {
                    if(visited[it]==1){
                        flag=false;
                        break;
                    }
                }
                if(!flag){
                   break;
                }
                else{
                    list.add(i);
                }
            }
            
        }
        if(!flag){
            list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(i);
            }
        }
        return list;



    }
}