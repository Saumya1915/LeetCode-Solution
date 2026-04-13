class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }

        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int count=0;
        int maxi=0;
        for(int i=0;i<nums.length;i++){

            sum+=nums[i];
            if(sum==0){
                maxi=Math.max(maxi,i+1);
            }
            else if(map.containsKey(sum)){
                maxi=Math.max(maxi,i-map.get(sum));
                
            }
            else{
                map.put(sum,i);
            }
            

        }
        return maxi;
         
    }
}