class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer>map=new HashMap<>();
        HashMap<Integer,ArrayList<Integer>>hs=new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int ball=queries[i][0];
            int color=queries[i][1];
            if(!map.containsKey(ball)){
                map.put(ball,color);
                if(!hs.containsKey(color)){
                    hs.put(color,new ArrayList<>());
                }
                hs.get(color).add(ball);
                
            }
            else{
                int color2=map.get(ball);
                ArrayList<Integer>list=hs.get(color2);
                list.remove(Integer.valueOf(ball));
                if(list.size()>0){
                    hs.put(color2,list);
                }
                else{
                    hs.remove(color2);
                }
                map.put(ball,color);
                if(!hs.containsKey(color)){
                    hs.put(color,new ArrayList<>());
                }
                hs.get(color).add(ball);
                
            }
            ans[i]=hs.size();
            
        }
        return ans;
    }
}