class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        int maxi=nums[0];
        int mini=nums[0];
         for(int i=1;i<nums.length;i++)
         {
            maxi=Math.max(maxi+nums[i],nums[i]);
            mini=Math.max(maxi,mini);

         }
         return mini; 
        

    }
}