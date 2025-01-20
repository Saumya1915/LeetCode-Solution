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

        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int row[]:dp){
            Arrays.fill(row,0);
        }
        //return solve(s.length()-1,t.length()-1,s,t,dp);
        for(int i=0;i<=s.length();i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=s.length();i++){

            for(int j=1;j<=t.length();j++){

                int count=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    count+=dp[i-1][j-1];
                }
                count+=dp[i-1][j];
                dp[i][j]=count;


            }
        }
        return dp[s.length()][t.length()];

        
    }
}