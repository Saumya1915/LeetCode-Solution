class Solution {
    int parent[];
    int rank[];
    public int findParent(int u){

        if(u==parent[u]){
            return u;
        }

        return parent[u]=findParent(parent[u]);

    }
    public void union(int u,int v){

        if(rank[v]>rank[u]){
            parent[u]=v;
        }
        else if(rank[u]>rank[v]){
            parent[v]=u;
        }
        else{
            parent[u]=v;
            rank[v]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent=new int[accounts.size()];
        rank=new int[accounts.size()];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        String names[]=new String[accounts.size()];

        for(int i=0;i<accounts.size();i++){

            names[i]=accounts.get(i).get(0);
        }
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<accounts.size();i++)
        {

            for(int str=1;str<accounts.get(i).size();str++){

                if(map.containsKey(accounts.get(i).get(str))){
                   int u=parent[i];
                   int v=map.get(accounts.get(i).get(str));
                   int pu=findParent(u);
                   int pv=findParent(v);
                   if(pu!=pv){
                     union(pu,pv);
                   }

                }
                else{
                    map.put(accounts.get(i).get(str),i);
                }
            }
        }
        //System.out.println(map);
        // for(int i=0;i<parent.length;i++){
        //     System.out.print(parent[i]+" ");
        // }

        ArrayList<ArrayList<String>>list=new ArrayList<>();

        for(int i=0;i<accounts.size();i++){

            list.add(new ArrayList<>());

        }
        for(String str:map.keySet()){

            int n=map.get(str);
            int index=findParent(n);
            list.get(index).add(str);
        }
        //System.out.println(list);

        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<list.size();i++){
             
             List<String>ans2=list.get(i);
             if(!ans2.isEmpty()){
                
                Collections.sort(ans2);
                List<String>ans3=new ArrayList<>();
                ans3.add(names[i]);
                ans3.addAll(ans2);
                ans.add(ans3);
                
             }

        }
        return ans;



    }
}