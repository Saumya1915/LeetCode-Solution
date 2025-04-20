class Solution {
    public boolean solve(HashMap<Integer,Integer>map,int i,int k,int dp[][],int[] stones){

            
        if(i==stones.length-1){
            return true;
        }
        if(dp[i][k]!=-1){
            return dp[i][k]==1;
        }
        
        boolean ans1=false;
        boolean ans2=false;
        boolean ans3=false;
        if(map.containsKey(k+stones[i]))
        {
            ans1=solve(map,map.get(k+stones[i]),k,dp,stones);
        }
        if(k>1 && map.containsKey(k+stones[i]-1))
        {
            ans2=solve(map,map.get(k+stones[i]-1),k-1,dp,stones);
        }
        if(map.containsKey(k+stones[i]+1))
        {
            ans3=solve(map,map.get(k+stones[i]+1),k+1,dp,stones);
        }
        dp[i][k]=(ans1||ans2||ans3)?1:0;
        
        return dp[i][k]==1;


    }
    public boolean canCross(int[] stones) {
        if(stones[1]-stones[0]!=1){
            return false;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int dp[][]=new int[stones.length][stones.length];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        return solve(map,1,1,dp,stones);


    }
}