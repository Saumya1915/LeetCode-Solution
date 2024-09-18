class Solution {
    public void dfs(int i,int visited[],List<List<Integer>> adj){

        visited[i]=1;
        for(Integer it:adj.get(i)){
            if(visited[it]==0){
                dfs(it,visited,adj);
            }
        }
    }
    public int removeStones(int[][] stones) {
       List<List<Integer>> adj=new ArrayList<>();
       int n=stones.length;
       for(int i=0;i<n;i++){
          adj.add(new ArrayList<>());
       } 

       for(int i=0;i<n;i++){
         for(int j=i+1;j<n;j++){
            if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
         }
       }
       int count=0;
       int visited[]=new int[n];
       for(int i=0;i<n;i++){
          if(visited[i]==0){
            count++;
            dfs(i,visited,adj);
          }
       }
       return n-count;

    }
}