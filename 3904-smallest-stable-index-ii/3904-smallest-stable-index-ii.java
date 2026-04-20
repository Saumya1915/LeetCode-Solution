class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxi[]=new int[nums.length];
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            maxValue=Math.max(maxValue,nums[i]);
            maxi[i]=maxValue;
            
        }

        

        int mini[]=new int[nums.length];
        int minValue=Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            minValue=Math.min(minValue,nums[i]);
            mini[i]=minValue;
        }

        

        
        for(int i=0;i<nums.length;i++){
            int ans=maxi[i]-mini[i];
            if(ans<=k){
                return i;
                
            }
        }
        return -1;
        
    }
}