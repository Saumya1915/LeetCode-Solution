class Solution 
{
    public long binarySearchRight(int nums[],int upper,int start)
    {

            int end=nums.length-1;
            long ans=-1;
            while(start<=end)
            {

                int mid=start+(end-start)/2;

                if(nums[mid]<=upper)
                {
                    ans=mid;
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
            return ans;
        }


    public long binarySearchLeft(int nums[],int lower,int start)
    {

            int end=nums.length-1;
            long ans=-1;
            while(start<=end){

                int mid=start+(end-start)/2;

                if(nums[mid]>=lower){
                    ans=mid;
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            return ans;
        }
    public long countFairPairs(int[] nums, int lower, int upper)
     {
        
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<nums.length;i++){

            int value=nums[i];
            int newUpper=upper-value;
            int newLower=lower-value;

            long index=binarySearchLeft(nums,newLower,i+1);
            long index2=binarySearchRight(nums,newUpper,i+1);
            //System.out.println(index+"---->"+index2);
            if(index!=-1 && index2!=-1)
            sum+=index2-index+1;





        }
        return sum;

        

        

    }
}