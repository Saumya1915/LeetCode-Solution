class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int index=0;
        int frequency[]=new int[51];
        int j=0;
        int t=0;
        for(;j<k;j++){
            int val=0-nums[j];
            if(val>0){
                frequency[val]++;
            }
        }
        int count=0;
        for(int i=50;i>=1;i--){
            if(frequency[i]>=1){
                count+=frequency[i];
                if(count>=x){
                    ans[index++]=-i;
                    break;
                }
            }
        }
        if(count<x){
            ans[index++]=0;
        }
        
        while(j<nums.length)
        {
            int val=0-nums[t++];
            if(val>0){
                frequency[val]--;
            }

            val=0-nums[j++];
            if(val>0){
                frequency[val]++;
            }

            count=0;
            for(int i=50;i>=1;i--){
                if(frequency[i]>=1){
                    count+=frequency[i];
                    if(count>=x){
                        ans[index++]=-i;
                        break;
                    }
                }
            }
            if(count<x){
                ans[index++]=0;
            }



        }
        return ans;


         
        
        
        
    }
}