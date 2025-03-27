class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
        }
        int maxi=0;
        int number=0;
        for(Integer num:map.keySet()){
            if(maxi<map.get(num)){
                maxi=map.get(num);
                number=num;
            }
        }
        int left=0;
        int right=maxi;
        int n=nums.size();
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==number){
                left++;
                right--;
                //System.out.println(right+"vvv"+left);
                if(left*2>(i+1) && right*2>n-(i+1)){
                    return i;
                }
            }
        }
        return -1;
    }
}