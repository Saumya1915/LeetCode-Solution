class Solution {
    int startPoint=Integer.MAX_VALUE;
    int endPoint=-1;
    public void binarySearchMin(int [] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                startPoint=Math.min(startPoint,mid);
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
    }

    public void binarySearchMax(int [] nums,int target){
        int start=0;
        int end=nums.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                endPoint=Math.max(endPoint,mid);
                start=mid+1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
    }
    public int[] searchRange(int[] nums, int target) {
        binarySearchMin(nums,target);
        if(startPoint==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        binarySearchMax(nums,target);
        return new int[]{startPoint,endPoint};

    }
}