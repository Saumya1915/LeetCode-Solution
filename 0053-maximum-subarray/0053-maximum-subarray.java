class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int i=0;
        int start=0;
        int maxi=Integer.MIN_VALUE;
        while(i<nums.length){

            if(nums[i]<0 && start==i){
                maxi=Math.max(maxi,nums[i]);
                i++;
                start=i;
                continue;
            }
            else{
                sum+=nums[i];
                maxi=Math.max(maxi,sum);
                if(sum<0){
                    sum=0;
                    i++;
                    start=i;
                }
                else{
                    i++;
                }

            }
            
        }
        return maxi;
    }
}