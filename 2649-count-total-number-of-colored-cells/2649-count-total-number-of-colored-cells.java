class Solution {
    public long solve(long n){
        if(n==1){
            return 1;
        }
        long a=solve(n-1);
        return a+(4*(n-1));
    }
    public long coloredCells(int n) {
        long a=(long)n;
        return solve(a);
    }
}