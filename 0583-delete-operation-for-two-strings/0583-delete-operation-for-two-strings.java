class Solution {
    public int minDistance(String str, String s) {
        int dp[][]=new int[str.length()+1][s.length()+1];
        for(int i=1;i<=str.length();i++){

            for(int j=1;j<=s.length();j++){

                if(str.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }
        int count=dp[str.length()][s.length()];
        return str.length()+s.length()-(2*count);
    
    }
}