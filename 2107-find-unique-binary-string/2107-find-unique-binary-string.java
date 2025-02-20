class Solution {
    boolean flag=false;
    public StringBuilder solve(HashSet<String>set,StringBuilder str,int index){

        if(str.length()==index)
        {
            if(!set.contains(str.toString())){
                flag=true;
            }
            return str;

        }

        str=solve(set,str,index+1);
        if(flag){
            return str;
        }

        str.setCharAt(index,'1');
        str=solve(set,str,index+1);
        if(flag){
            
            return str;
        }
        str.setCharAt(index,'0');
        return str;
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){

            set.add(nums[i]);
        
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nums.length;i++)
        {
            str.append("0");
        }
        return solve(set,str,0).toString();




        

    }
}