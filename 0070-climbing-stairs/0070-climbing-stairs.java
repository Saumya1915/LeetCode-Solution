class Solution {
    public int climbStairs(int n) {
        int prev=1;
        int prev2=1;
        if(n==0){
            return prev;
        }
        int curri=0;
        for(int i=2;i<=n;i++){
            curri=prev+prev2;
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}