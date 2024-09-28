class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(Integer it:map.keySet()){
            int num=map.get(it);
            if(num==1){
                return it;
            }
        }
        return 0;

    }
}