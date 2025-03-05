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
                dp[index]=1;
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

        Arrays.fill(dp,0);
        dp[nums.length-1]=1;
        int value=1;
        for(int i=nums.length-2;i>=0;i--){
            
            if(nums[i]!=0){
               if(nums[i]>=value){
                    dp[i]=1;
                    value=1;
               }
               else{
                value++;
               }
            }
            else{
                value++;
            }
        }
        return dp[0]==1;

       //solve(nums,0,dp);
       //return dp[0]==1;
    }
}