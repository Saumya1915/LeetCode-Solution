class Solution {
    public boolean solve(int nums[],int index,int dp[]){
        if(index>=nums.length-1){
            return true;
        }
        if(dp[index]!=-1){
            return dp[index]==1;
        }
        for(int i=1;i<=nums[index];i++){
            if(solve(nums,index+i,dp)){
                if(index+i<nums.length){
                    dp[index]=1;
                }
                return true;
            }
            
        }
        dp[index]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
       int dp[]=new int[nums.length];
       if(nums.length==1){
        return true;
       }
        Arrays.fill(dp,-1);
       solve(nums,0,dp);
       return dp[0]==1;
    }
}