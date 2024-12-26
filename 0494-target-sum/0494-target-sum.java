class Solution {
    public int solve(int index,int nums[],int target){

        if(index<0 && target==0){
            return 1;
        }
        if(index<0 && target!=0){
            return 0;
        }
        int add=solve(index-1,nums,target-nums[index]);
        int sub=solve(index-1,nums,target+nums[index]);
        return add+sub;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length-1,nums,target);


        
    }
}