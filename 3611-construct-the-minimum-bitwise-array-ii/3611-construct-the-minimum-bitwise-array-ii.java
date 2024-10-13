class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int ans[]=new int[nums.size()];

        for(int i=0;i<nums.size();i++){
            int num=0;
            boolean flag=false;
            int value=nums.get(i);
            if(value==2){
                ans[i]=-1;
                continue;
            }
            int count=0;
            int numCopy=value;
            while((value &1)==1){
                count++;
                value=value>>1;
            }

            ans[i]= numCopy-(1<<(count-1));

            

        }
        return ans;
        
    }
}