class Solution {
    public int solve(int[] array,int index,int dp[]){
        if(index==array.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        //OPTION1
        if(index<array.length){
            sum+=array[index];
            maxi=Math.max(maxi,sum-solve(array,index+1,dp));
        }
        if(index+1<array.length){
            sum+=array[index+1];
            maxi=Math.max(maxi,sum-solve(array,index+2,dp));
        }
        if(index+2<array.length){
            sum+=array[index+2];
            maxi=Math.max(maxi,sum-solve(array,index+3,dp));
        }
        return dp[index]=maxi;


    }
    public String stoneGameIII(int[] stoneValue) {
        int dp[]=new int[stoneValue.length];
        Arrays.fill(dp,-1);

        int value=solve(stoneValue,0,dp);
        if(value>0){
            return "Alice";
        }
        else if(value<0){
            return "Bob";
        }
        return "Tie";
        
        
    }
}