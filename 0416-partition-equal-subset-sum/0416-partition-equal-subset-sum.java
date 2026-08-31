class Solution {
    public boolean solve(int[] nums, int sum, int index,int ans,int array[][]){
        if(index>=nums.length){
            return false;
        }
        if(ans==sum){
            return true;
        }

        if(array[index][sum]!=-1){
            return array[index][sum]==1?true:false;
        }

        //include
        boolean a=solve(nums,sum-nums[index],index+1,ans+nums[index],array);

        //don't include
        boolean b=solve(nums,sum,index+1,ans,array);
        array[index][sum]=a||b==true?1:0;
        return a||b;

    }
    public boolean canPartition(int[] nums) {

        int sum=0;
        
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        } 
        int array[][]=new int[nums.length][sum+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(array[i],-1);
        }
       if(sum%2!=0){
          return false;
       }
       return solve(nums,sum,0,0,array);
    }
}