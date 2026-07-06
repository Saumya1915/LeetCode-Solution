class Solution {
    public int solve(int n,int array[]){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(array[n]!=-1){
            return array[n];
        }
        int ans=solve(n-1,array)+solve(n-2,array);
        array[n]=ans;
        return ans;
    }
    public int fib(int n) {
        int array[]=new int[n+1];
        Arrays.fill(array,-1);
        return solve(n,array);
        
    }
}