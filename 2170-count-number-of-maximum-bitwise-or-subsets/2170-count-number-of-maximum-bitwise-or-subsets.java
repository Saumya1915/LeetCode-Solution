class Solution {
    int maxi=-1;
    int sum=0;

    public void help(int array[],int index,List<Integer> output){

        if(index>=array.length){
            int ans=0;
            for(int i=0;i<output.size();i++){

                ans=ans|output.get(i);
            }

            if(ans>maxi){
                maxi=ans;
                sum=1;
            }
            else if(ans==maxi){
                sum++;
            }
            return;
        }

        //exclude

        help(array,index+1,output);

        //include
        int element=array[index];
        output.add(element);
        help(array,index+1,output);
        output.remove(output.size()-1);
    }
    public int countMaxOrSubsets(int[] nums) {
        help(nums,0,new ArrayList<Integer>());
        return sum;
    }
}