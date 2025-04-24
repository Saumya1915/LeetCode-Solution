class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> distinct=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            distinct.add(nums[i]);
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> set=new HashSet<>();
            set.add(nums[i]);
            if(set.size()==distinct.size()){
                sum++;
            }
            for(int j=i+1;j<nums.length;j++){
              set.add(nums[j]);
              if(set.size()==distinct.size()){
                  sum++;
              }
            }
        }
        return sum;
    }
}