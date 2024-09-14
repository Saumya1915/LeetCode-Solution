class Solution {
    public void dfs(int x,int y,List<List<Integer>>ans,List<List<Integer>>list,int array[]){
        for(Integer ch:list.get(y)){
            if(array[ch]==0){
            array[ch]=1;
            dfs(x,ch,ans,list,array);
            
            ans.get(x).add(ch);}
        }
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
             int x=prerequisites[i][0];
             int y=prerequisites[i][1];
             list.get(x).add(y);

        }
        System.out.println(list);
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ans.add(new ArrayList<>());
        }

        for(int i=0;i<numCourses;i++){

            dfs(i,i,ans,list,new int[numCourses]);
        }
        System.out.println(ans);

        List<Boolean>ansList=new ArrayList<>();
        for(int i=0;i<queries.length;i++){

            int x=queries[i][0];
            int y=queries[i][1];
            boolean flag=false;
            for(int j=0;j<ans.get(x).size();j++){
                if(ans.get(x).get(j)==y){
                    flag=true;
                    ansList.add(true);
                    break;
                }
            }
            if(!flag){
                ansList.add(false);
            }
            
        }
        return ansList;
        
    }
}