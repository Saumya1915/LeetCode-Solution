class Solution {
   public boolean isPossible(int n,int[] array,int mid){
       int count=0;
       for(int i=0;i<array.length;i++){
           if(array[i]%mid==0){
               count+=array[i]/mid;

           }
           else{
               count+=array[i]/mid;
               count++;
           }
       }
       if(count>n){
           return false;
       }
       return true;
   }

    public int minimizedMaximum(int n, int[] quantities) {
        int start=1;
        int end=0;
        for(int i=0;i<quantities.length;i++){
            end=Math.max(end,quantities[i]);
        }
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(n,quantities,mid)){
                 ans=mid;
                 end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}