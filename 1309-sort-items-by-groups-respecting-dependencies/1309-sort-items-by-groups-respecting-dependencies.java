class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<group.length;i++){
            if(group[i]==-1){
                map.put(i,m++);
            }
            else{
                map.put(i,group[i]);
            }
        }
       List<List<Integer>> list3=new ArrayList<>();
       for(int i=0;i<n;i++){
        list3.add(new ArrayList<>());
       }
        int indegree[]=new int[n];
        for(int i=0;i<beforeItems.size();i++){
            int size=beforeItems.get(i).size();

            indegree[i]=size;
            for(int j=0;j<beforeItems.get(i).size();j++){
                 list3.get(beforeItems.get(i).get(j)).add(i);
            }
        }

        Queue<Integer>q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){

            int value=q.remove();
            list.add(value);
            for(Integer it:list3.get(value)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }

        }

        System.out.println(list);
        if(list.size()<n){
            return new int[0];
        }

        List<List<Integer>>groups=new ArrayList<>();
        for(int i=0;i<m;i++){
            groups.add(new ArrayList<>());
        }
        int indeg[]=new int[m];
        for(int i=0;i<beforeItems.size();i++){
            int x=map.get(i);
            for(int j=0;j<beforeItems.get(i).size();j++){
                int y=map.get(beforeItems.get(i).get(j));
                if(x!=y){
                    groups.get(y).add(x);
                    indeg[x]++;
                }
            }
        }
        // for(int i=0;i<m;i++){
        // System.out.print(indeg[i]+"  ");}

        q=new LinkedList<>();
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
         List<Integer> list2=new ArrayList<>();
         while(!q.isEmpty()){

            int value=q.remove();
            list2.add(value);
            for(Integer it:groups.get(value)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }

        }
        if (list2.size() < m) {
            return new int[0]; // Cycle detected in groups or not all sorted
        }
        System.out.println(list2);

        HashMap<Integer,ArrayList<Integer>>map2=new HashMap<>();

        for(int i=0;i<m;i++){
            map2.put(i,new ArrayList<>());
        }

        for(int i=0;i<list.size();i++){
            int x=list.get(i);
            map2.get(map.get(x)).add(x);
        }
         int index=0;
        int ans[]=new int[n];
        for(int i=0;i<list2.size();i++){
            int x=list2.get(i);
            for(Integer it:map2.get(x)){
                ans[index++]=it;
            }
        }

        return ans;


        
    }
}