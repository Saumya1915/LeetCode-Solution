class Solution {
    public int solve(int[] array,int index,int n,int[][] dp){

        if(n==0){
            return 0;
        }
        if(index==0)
        {
            if(n%array[index]==0){
                return n/array[index];
            }
            else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[index][n]!=-1){
            return dp[index][n];
        }

        int not=solve(array,index-1,n,dp);
        int take=Integer.MAX_VALUE;
        if(n>=array[index]){
            int value=solve(array,index,n-array[index],dp);
            if(value!=Integer.MAX_VALUE){
                take=1+value;
            }
        }
        return dp[index][n]=Math.min(not,take);

    }
    public int numSquares(int n) {
       int a=(int)Math.sqrt((double)(n));
       int array[]=new int[a];
       int num=1;
       int dp[][]=new int[array.length][n+1];
       for(int row[]:dp){
       Arrays.fill(row,0);
       }
       for(int i=0;i<array.length;i++){
            array[i]=num*num;
            //System.out.println(array[i]);
            num++;
        }
        //return solve(array,array.length-1,n,dp);
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<dp.length;i++){

            for(int j=1;j<dp[0].length;j++){

                int not=dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(j>=array[i]){
                int value=dp[i][j-array[i]];
                    if(value!=Integer.MAX_VALUE){
                        take=1+value;
                    }
                }
                dp[i][j]=Math.min(not,take);
            }
        }
        return dp[dp.length-1][n];



    }
}