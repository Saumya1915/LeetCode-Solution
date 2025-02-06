class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }

        int maxi=0;
        for (int count : map.values()) 
        {
        if (count > 1) {
            maxi += (count * (count - 1) / 2) * 8;}
        }
    
    return maxi;




    }
}