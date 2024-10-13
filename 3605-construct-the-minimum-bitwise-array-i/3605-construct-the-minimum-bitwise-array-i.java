class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[]=new int[nums.size()];
        for(int i=0;i<nums.size();i++){

            int value=nums.get(i);
            for(int j=0;j<1000;j++){

                int num=j|j+1;
                if(value==num){
                    ans[i]=j;
                    break;
                }

            }
            if(ans[i]==0){
                ans[i]=-1;
            }

        }
        return ans;
    }
}