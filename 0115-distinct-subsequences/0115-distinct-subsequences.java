class Solution {
    public static int solve(int i,int j,String s1,String s2,int[][] dp){

        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int count=0;
        if(s1.charAt(i)==s2.charAt(j)){
            //System.out.println(s1.charAt(i)+"--->"+i);
            //System.out.println(s2.charAt(j)+"-->"+j);

            count+=solve(i-1,j-1,s1,s2,dp);
        }
        count+=solve(i-1,j,s1,s2,dp);
        return dp[i][j]=count;
    }
    public int numDistinct(String s, String t) {

        int dp[][]=new int[s.length()][t.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return solve(s.length()-1,t.length()-1,s,t,dp);
        
    }
}