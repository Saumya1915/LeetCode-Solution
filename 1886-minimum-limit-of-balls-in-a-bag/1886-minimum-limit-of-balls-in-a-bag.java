class Solution {
    public boolean isPossible(int[] nums, int maxOperations,int mid){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mid){
                if(nums[i]% mid!=0){
                    count+=nums[i]/mid;
                }
                else{
                    count+=nums[i]/mid-1;
                }
            }
        }
        if(count>maxOperations){
            return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int start=1;
        int end=0;
        for(int i=0;i<nums.length;i++){
            end=Math.max(end,nums[i]);
        }
        int ans=0;
        while(start<=end){
          int mid=start+(end-start)/2;
          if(isPossible(nums,maxOperations,mid)){
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