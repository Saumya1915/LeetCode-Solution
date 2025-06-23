class Solution {
    public int solve(int nums[],int ans[],int index1,int index2,int last,int[][] dp){
        if(index1<0 || index2<0){
            return 0;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }

        if(ans[index1]==nums[index2] && last!=ans[index1]){
            return dp[index1][index2]=1+solve(nums,ans,index1-1,index2-1,ans[index1],dp);
        }
        else{
            return dp[index1][index2]=Math.max(solve(nums,ans,index1-1,index2,last,dp),solve(nums,ans,index1,index2-1,last,dp));
        }
    }
    public int lengthOfLIS(int[] nums) {
        int[] ans=new int[nums.length];
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
            set.add(nums[i]);
        }
        if(set.size()==1){
            return 1;
        }
        Arrays.sort(ans);
        
        int dp[][]=new int[nums.length][nums.length];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,ans,nums.length-1,ans.length-1,Integer.MIN_VALUE,dp);
        
    }
}