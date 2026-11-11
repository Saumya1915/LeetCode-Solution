class Solution {
    public int commonFactors(int a, int b) {
        int sum=0;
        int smallest=Math.min(a,b);
        for(int i=1;i<=smallest;i++){
            if(a%i==0 && b%i==0){
                sum++;
            }
        }
        return sum;
    }
}