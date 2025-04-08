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
        //boolean dp[][]=new boolean[nums.length][target+1];
        //for(int[] row:dp){
            //Arrays.fill(row,0);
        //}
        target=target/2;
        //return solve(target/2,nums,nums.length-1,dp);
        
        boolean prev[]=new boolean[target+1];
        if(nums[0]<=target)
         prev[nums[0]]=true;

        for(int i=1;i<nums.length;i++){
            boolean current[]=new boolean[target+1];
            current[0]=true;
            for(int j=1;j<=target;j++){

                boolean notake=prev[j];

                 //take
                boolean take=false;
                if(nums[i]<=j)
                take=prev[j-nums[i]];

                current[j]=(take||notake);


            }
            prev=current;
        }
        return prev[target]==true;

        



        
    }
}