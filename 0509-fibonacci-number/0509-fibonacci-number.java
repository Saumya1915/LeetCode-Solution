class Solution {
    // public int solve(int n,int array[]){
    //     if(n==0){
    //         return 0;
    //     }
    //     if(n==1){
    //         return 1;
    //     }
    //     if(array[n]!=-1){
    //         return array[n];
    //     }
    //     int ans=solve(n-1,array)+solve(n-2,array);
    //     array[n]=ans;
    //     return ans;
    // }
    public int fib(int n) {
        int prev_prev=0;
        int prev=1;
        if(n==0){
            return prev_prev;
        }
        if(n==1){
            return prev;
        }
        for(int i=2;i<=n;i++){
            int ans=prev_prev+prev;
            prev_prev=prev;
            prev=ans;
        }
        return prev;
        
        
    }
}