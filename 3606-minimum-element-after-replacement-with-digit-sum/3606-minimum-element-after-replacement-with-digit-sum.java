class Solution {
    public int minElement(int[] nums) {
        for(int i=0;i<nums.length;i++){

            int value=nums[i];
            int sum=0;
            while(value>0){
                 sum+=value%10;
                 value/=10;
            }
            nums[i]=sum;
        }
        Arrays.sort(nums);
        return nums[0];
    }
}