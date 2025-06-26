class Solution {
    public int findNumberOfLIS(int[] nums) {
       int len[]=new int[nums.length];
       int count[]=new int[nums.length];
       Arrays.fill(len,1);
       Arrays.fill(count,1);
       for(int i=0;i<nums.length;i++)
       {
        for(int j=0;j<i;j++){
            if(nums[i]>nums[j]){
                if(len[j]+1>len[i]){
                    len[i]=len[j]+1;
                    count[i]=0;
                }
                if(len[j]+1==len[i]){
                    count[i]+=count[j];
                }
            }
        }
       }
       int maxi=Integer.MIN_VALUE;
       for(int i=0;i<len.length;i++){
        maxi=Math.max(len[i],maxi);
       }
       int result=0;
       for(int i=0;i<count.length;i++){
            if(len[i]==maxi){
                result+=count[i];
            }
       }
       return result;

    }
}