class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long maxi=0;
        long sum=0;
        int start=0;
        int end=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        while(end<nums.length)
        {

            sum+=nums[end];
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);

            if(end-start+1==k)
            {
                if(map.size()==k){
                    maxi=Math.max(maxi,sum);
                }

                sum-=nums[start];

                map.put(nums[start],map.get(nums[start])-1);
                if(map.get(nums[start])==0)
                {
                    map.remove(nums[start]);
                }

                start++;
            }
            end++;
        }
        return maxi;

        
    }
}