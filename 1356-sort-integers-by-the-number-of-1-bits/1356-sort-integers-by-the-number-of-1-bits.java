class Solution {
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer,ArrayList<Integer>>map=new TreeMap<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int count=0;
            int num=arr[i];
            while(num>0){
                if((num&1)==1){
                    count++;
                }
                num>>=1;
            }
            if(!map.containsKey(count)){
                map.put(count,new ArrayList<Integer>());

            }
            map.get(count).add(arr[i]);
        }
        //System.out.println(map);
        int index=0;
        for(Integer key:map.keySet()){
           ArrayList<Integer> list=map.get(key);
           Collections.sort(list);
           for(int i=0;i<list.size();i++){
               ans[index++]=list.get(i);
           }
        }
        return ans;
        
    }
}