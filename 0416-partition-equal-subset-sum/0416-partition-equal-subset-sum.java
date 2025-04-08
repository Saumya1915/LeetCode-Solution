class Solution {
    public boolean solve(int target,int[] nums,int index,int dp[][]){
        if(target==0){
            return true;
        }
        if(index==0){
            return target==nums[index];
        }
        if(dp[index][target]!=-1){
            return dp[index][target]==1;
        }
          

        //notake
        boolean notake=solve(target,nums,index-1,dp);

        //take
        boolean take=false;
        if(nums[index]<=target)
        take=solve(target-nums[index],nums,index-1,dp);

         dp[index][target]=(take||notake)?1:0;
         return take||notake;
    }
    public boolean canPartition(int[] nums) {
        int target=0;
        for(int i=0;i<nums.length;i++){
            target+=nums[i];
        }

        if(target%2!=0){
            return false;
        }
        boolean dp[][]=new boolean[nums.length][target+1];
        //for(int[] row:dp){
            //Arrays.fill(row,0);
        //}
        target=target/2;
        //return solve(target/2,nums,nums.length-1,dp);
        dp[0][nums[0]]=true;
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<nums.length;i++){

            for(int j=1;j<=target;j++){

                boolean notake=dp[i-1][j];

                 //take
                boolean take=false;
                if(nums[i]<=j)
                take=dp[i-1][j-nums[i]];

                dp[i][j]=(take||notake);


            }
        }
        return dp[nums.length-1][target]==true;

        



        
    }
}