class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int setBits=0;
            for(int j=0;j<nums.length;j++){
                int value=nums[j];
                if(((value>>i)&1)==1){
                    setBits++;
                }
            }
            if(setBits%3!=0){
                int sum=setBits%3;
               ans|=sum<<i;
            }
        }
        return ans;
    }
}