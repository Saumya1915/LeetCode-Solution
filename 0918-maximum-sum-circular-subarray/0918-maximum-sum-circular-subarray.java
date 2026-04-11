class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int maxi=Integer.MIN_VALUE;
        int totalSum=0;
         for(int i=0;i<nums.length;i++){
             sum+=nums[i];
             totalSum+=nums[i];
             maxi=Math.max(maxi,sum);
             if(sum<0){
                sum=0;
             }
         }
         sum=0;
         int mini=Integer.MAX_VALUE;
         for(int i=0;i<nums.length;i++)
         {
             sum+=nums[i];
             mini=Math.min(mini,sum);
             if(sum>0){
                sum=0;
             }

         }

         if(mini==totalSum){
            return maxi;
         }

         return Math.max(maxi,totalSum-mini);
        
    }
}