class Solution {
    public boolean canSortArray(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            boolean swapped=false;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int num=Integer.bitCount(nums[j]);
                    int num1=Integer.bitCount(nums[j+1]);
                    if(num==num1){
                        int temp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=temp;
                    }
                    else{
                        //System.out.println(num1+"  "+num);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}