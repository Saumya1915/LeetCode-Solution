class Solution {
    public int solve(int target,int index,List<Integer>nums,int[][] dp){
        if(target==0){
            return 0;
        }
        if(index==0){
            if(target==nums.get(index)){
                return 1;
            }
            return Integer.MIN_VALUE;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int take=solve(target,index-1,nums,dp);

        int not=Integer.MIN_VALUE;
        if(target>=nums.get(index)){
            int value=solve(target-nums.get(index),index-1,nums,dp);
           if(value!=Integer.MIN_VALUE){
                not=1+value;
           };
         }

        return dp[index][target]=Math.max(take,not);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int dp[][]=new int[nums.size()][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int a=solve(target,nums.size()-1,nums,dp);

        if(a==Integer.MIN_VALUE){
            return -1;
        }
        return a;
    }
}