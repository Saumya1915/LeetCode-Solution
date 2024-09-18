class Solution {
    public String largestNumber(int[] nums) {
     
        String array[]=new String[nums.length];
        array[0]=String.valueOf(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            String str=String.valueOf(nums[i]);
            int j=i-1;
            for(;j>=0;j--){
                String s1=String.valueOf(array[j]);
                String a=str+s1;
                String b=s1+str;
                if((a.compareTo(b)>0)){
                    array[j+1]=array[j];
                }
                else{
                    break;
                }

            }
            array[j+1]=String.valueOf(nums[i]);
        }
        if((array[0].compareTo("0"))==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<array.length;i++){
            sb.append(array[i]);
        }
        return sb.toString();

    }
}