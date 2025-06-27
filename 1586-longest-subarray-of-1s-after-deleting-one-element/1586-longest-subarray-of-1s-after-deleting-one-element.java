class Solution {
    public int longestSubarray(int[] nums) {
       ArrayDeque<Integer> ad=new ArrayDeque<>();
       int count0=0;
       int maxi=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if((count0+1)!=2){
                    count0++;
                }
                else{
                    while(ad.peek()!=0){
                        ad.removeFirst();
                    }
                    ad.removeFirst();
                }
                ad.add(nums[i]);
            }
            else{
                ad.add(nums[i]);
            }
            maxi=Math.max(ad.size()-1,maxi);
       }
       return maxi; 
    }
}