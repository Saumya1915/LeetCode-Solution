class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        long sum=0;
        int last=Integer.MAX_VALUE;
        for(int i=maximumHeight.length-1;i>=0;i--){

            int height=Math.min(maximumHeight[i],last-1);
            if(height<=0){
                return -1;
            }
            sum+=height;
            last=height;
        }
        return sum;
    }
}