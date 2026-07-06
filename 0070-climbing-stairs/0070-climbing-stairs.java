class Solution {
    public int solve(int n,int array[]){

        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return array[n]=climbStairs(n-1)+climbStairs(n-2);

    }
    public int climbStairs(int n) {

        int array[]=new int[n+2];
        Arrays.fill(array,-1);
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for(int i=3;i<=n;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[n];
        
    }
}