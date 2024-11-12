class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        
        HashMap<Integer,Integer>map=new HashMap<>();
        HashMap<Integer,Integer>map2=new HashMap<>();
        for(int i=0;i<items.length;i++){
            if(!map.containsKey(items[i][0])){
                map.put(items[i][0],items[i][1]);
            }
            else{
                int num=map.get(items[i][0]);
                map.put(items[i][0],Math.max(num,items[i][1]));
            }
        }
        //System.out.println(map);
        int ans[]=new int[queries.length];
        int array[]=new int[items.length];
       
        for(int i=0;i<array.length;i++){
            array[i]=items[i][0];
        }

        Arrays.sort(array);
        int maxi=map.get(array[0]);
        for(int i=0;i<array.length;i++){

            maxi=Math.max(maxi,map.get(array[i]));
            map2.put(array[i],maxi);
            
        }
        // for(int i=0;i<array.length;i++){
        //     System.out.print(array[i]+" ");
        // }
        for(int i=0;i<queries.length;i++)
        {

            int start=0;
            int end=array.length-1;
            int an=-1;
            while(start<=end)
            {

                int mid=start+(end-start)/2;

                if(array[mid]==queries[i]){
                    an=mid;
                    break;

                }
                else if(array[mid]>queries[i]){
                    end=mid-1;
                }
                else{
                    an=mid;
                    start=mid+1;
                }
                //System.out.println(an);

            }
            if(an==-1){
                ans[i]=0;
            }
            else{
                ans[i]=map2.get(array[an]);
            }
        }
        return ans;
    }
}