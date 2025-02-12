class Solution {
    public int maximumSum(int[] nums) {
        
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            int sum=0;
            int temp=nums[i];
            while(temp>0){
                sum+=temp%10;
                temp=temp/10;
            }
            ArrayList<Integer>list=new ArrayList<>();
            if(map.containsKey(sum)){
                list=map.get(sum);
            }
            list.add(nums[i]);
            map.put(sum,list);
        }
        int ans=-1;
        for(Integer key:map.keySet()){

            List<Integer>list=map.get(key);
            if(list.size()>1){
               Collections.sort(list);
               int num=list.get(list.size()-1)+list.get(list.size()-2);
               if(num>ans){
                ans=num;
               }
            }
        }
        return ans;

    }
}