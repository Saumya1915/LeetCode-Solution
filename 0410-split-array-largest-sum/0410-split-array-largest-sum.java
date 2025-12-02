class Solution {
    public boolean isPossible(int mid,int nums[],int k){

            int value=1;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                if(sum+nums[i]<=mid){
                    sum+=nums[i];
                }
                else{
                    value++;
                    if(value>k || nums[i]>mid){
                        return false;
                    }
                    sum=nums[i];
                }
            }
            return true;
        
    }
    public int splitArray(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int start=0;
        int end=sum;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(mid,nums,k)){
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
