class Solution {
    public void dfs(List<Integer> edge,int array[],List<List<Integer>>list,int i){
        for(Integer it:list.get(i)){
            if(array[it]==0){
                array[it]=1;
                dfs(edge,array,list,it);
            }
        }
        edge.add(i);
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>>list=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());

        }

        for(int i=0;i<edges.length;i++)
        {

            int x=edges[i][0];
            int y=edges[i][1];

            list.get(y).add(x);


        }
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {

            List<Integer> edge=new ArrayList<>();

            dfs(edge, new int[n],list,i);
            edge.remove(edge.size()-1);
            Collections.sort(edge);
            ans.get(i).addAll(edge);

        }
        return ans;
    }
}