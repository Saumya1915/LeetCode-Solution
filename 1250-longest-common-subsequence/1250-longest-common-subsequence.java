class Solution {
    public int solve(int index1,int index2,String text1,String text2,int[][] dp){
        if(index1<0 || index2<0){
            return 0;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        if(text1.charAt(index1)==text2.charAt(index2)){
            return dp[index1][index2]=1+solve(index1-1,index2-1,text1,text2,dp);
        }
        else{
            return dp[index1][index2]=Math.max(solve(index1-1,index2,text1,text2,dp),solve(index1,index2-1,text1,text2,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(text1.length()-1,text2.length()-1,text1,text2,dp);

    }
}