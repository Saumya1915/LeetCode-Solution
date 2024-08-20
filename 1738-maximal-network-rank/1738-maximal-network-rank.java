class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<roads.length;i++){
            int a=roads[i][0];
            int b=roads[i][1];

            map.put(a,map.getOrDefault(a,0)+1);
            map.put(b,map.getOrDefault(b,0)+1);
        }
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int a=roads[i][0];
            int b=roads[i][1];

            list.get(a).add(b);
            list.get(b).add(a);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            {
                if(i!=j && !list.get(i).isEmpty() && !list.get(j).isEmpty()){
                    int node1=map.get(i);
                    int node2=map.get(j);
                    int sum=node1+node2;
                    if(list.get(i).contains(j)){
                        sum-=1;
                    }

                ans=sum>ans? sum:ans;
                }
                }
        }

        return ans;
    }
}