class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int start=0;
        int maxi=0;
        for(int i=0;i<nums.length;i++){
                
            while(nums[i]-nums[start]>2*k){
                start++;
            }
            maxi=Math.max(maxi,i-start+1);
            
        }
        return maxi;
    }
}