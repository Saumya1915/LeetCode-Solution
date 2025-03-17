class Solution {
    public int solve(String s,int index,int[] dp)
    {
      if(s.length()==index){
        return 1;
      }
      if(s.charAt(index)=='0'){
        return 0;
      }
      if(dp[index]!=-1){
        return dp[index];
      }
      int sum=0;
      sum+=solve(s,index+1,dp);
      if(index+1<s.length()){
        String str=s.substring(index,index+2);
        int num=Integer.valueOf(str);
        if(num<=26){
            sum+=solve(s,index+2,dp);
        }
      }
      return dp[index]=sum;


    }
    public int numDecodings(String s) 
    {
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
       
        return solve(s,0,dp);

    }
}