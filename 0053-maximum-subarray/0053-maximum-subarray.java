class Solution 
{
    public int solve(int nums[],int index,int maxi,int mini){

        if(index==-1){
            return mini;
        }
        maxi=Math.max(maxi+nums[index],nums[index]);
        mini=Math.max(mini,maxi);
        return solve(nums,index-1,maxi,mini);
    }
    
    public int maxSubArray(int[] nums) 
    {
       
        return solve(nums,nums.length-2,nums[nums.length-1],nums[nums.length-1]);

    }
}