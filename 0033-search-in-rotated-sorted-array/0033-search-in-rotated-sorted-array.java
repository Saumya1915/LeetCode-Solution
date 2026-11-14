class Solution 
{

    public int pivotIndex(int nums[]){
        int start=0;
        int end=nums.length-1;
        int ans=-1;

        while(start<=end)
        {

            int mid=start+(end-start)/2;

            if(nums[mid]<=nums[nums.length-1]){
                end=mid-1;// we are on l2, move to l1, just do that
            }
            else{
                //you are already on l2, just find the pivot
                //what you are at can be the potential pivot so save it

                ans=mid;
                start=mid+1;


            }

        }
        return ans;

    }

    int binarySearch(int nums[],int target,int start,int end)
    {

        
        while(start<=end)
        {

            int mid=start+(end-start)/2;

            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return -1;
    }

    public int search(int[] nums, int target) 
    {

        int pivot=pivotIndex(nums);
        System.out.println(pivot);
        if(pivot==-1){
            return binarySearch(nums,target,0,nums.length-1);
        }

        if(target>=nums[0] && target<=nums[pivot]){
            return binarySearch(nums,target,0,pivot);
        }
        return binarySearch(nums,target,pivot+1,nums.length-1);
        
           
    }
}