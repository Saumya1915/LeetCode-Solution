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
        int dp[]=new int[stoneValue.length+1];
        Arrays.fill(dp,0);
        int prev1=0;
        int prev2=0;
        int prev3=0;
        for(int i=stoneValue.length-1;i>=0;i--){

            int maxi=Integer.MIN_VALUE;
            int sum=0;
            sum+=stoneValue[i];
            maxi=Math.max(maxi,sum-prev1);
            if(i+1<stoneValue.length){
                sum+=stoneValue[i+1];
                maxi=Math.max(maxi,sum-prev2);
            }
            if(i+2<stoneValue.length){
                sum+=stoneValue[i+2];
                maxi=Math.max(maxi,sum-prev3);
            }
            prev3=prev2;
            prev2=prev1;
            prev1=maxi;
        }
        int value=prev1;
        if(value>0){
            return "Alice";
        }
        else if(value<0){
            return "Bob";
        }
        return "Tie";
        
        
    }
}