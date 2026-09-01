class Solution {
    public int solve(int[] nums,int target,int index,int[][] array){
        if(index<0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(target<0){
            return 0;
        }

        if(target==0){
            return 1;
        }

        if(array[index][target]!=-1){
            return array[index][target]==1?1:0;
        }

        int a=solve(nums,target-nums[index],index-1, array);
        int b=solve(nums,target,index-1, array);
        return array[index][target]= a | b;


    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];

        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean[][] array=new boolean[nums.length][sum+1];
        // for(int i=0;i<nums.length;i++){
        //     Arrays.fill(array[i],-1);
        // }

        //return solve(nums,target,nums.length-1,array)==1? true:false;

        array[0][nums[0]]=true;
        for(int i=0;i<nums.length;i++){
            array[i][0]=true;
        }

        for(int i=1;i<nums.length;i++){

            for(int j=1;j<=target;j++)
            {
                boolean a=false;
                if(j>=nums[i])
                a=array[i-1][j-nums[i]];
                boolean b=array[i-1][j];
                array[i][j]=a||b;

                

            }
        }
        return array[nums.length-1][target];


        


    }
}