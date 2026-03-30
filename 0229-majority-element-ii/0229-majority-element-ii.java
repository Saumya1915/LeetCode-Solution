class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count=0;
        int length=nums.length/3;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int num=nums[0];
        for(int i=0;i<nums.length;i++)
        {

            if(num==nums[i]){
                count++;
                //System.out.println(count+"==="+num);
            }
            else{
                if(count>length){
                    list.add(num);
                }
                num=nums[i];
                count=1;
            }
        }

        if(count>length){
                    list.add(num);
        }

       return list;


    }
}