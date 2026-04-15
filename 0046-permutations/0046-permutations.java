class Solution {
    public void permutation(List<Integer> output,int index,List<List<Integer>>list){

        if(index>=output.size()){
            list.add(new ArrayList<>(output));
            return;
        }
        for(int j=index;j<output.size();j++){
            Collections.swap(output,index,j);
            permutation(output,index+1,list);
            Collections.swap(output,index,j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>output=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            output.add(nums[i]);
        }

        permutation(output,0,list);
        return list;



    }
}