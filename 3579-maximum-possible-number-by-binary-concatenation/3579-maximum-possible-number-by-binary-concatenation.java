class Solution {
    public int findTheNumber(int array[]){
         StringBuilder str=new StringBuilder();
         for(int i=0;i<array.length;i++){

            String str1=Integer.toBinaryString(array[i]);
            for(int j=0;j<str1.length();j++){
              char value=str1.charAt(j);
              if(value=='1'){
                str.append("1");
              }  
              else{
                str.append("0");
              }
                
            }
         }
         return Integer.parseInt(str.toString(),2);
    }

    public void swap(int i,int j,int array[]){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public void solve(int array[],List<Integer>list,int index){

        if(index>=array.length){

            int num=findTheNumber(array);
            list.add(num);
        }
        for(int j=index;j<array.length;j++){
            swap(index,j,array);
            solve(array,list,index+1);
            swap(index,j,array);
        }

    }

    public int maxGoodNumber(int[] nums) {
        List<Integer>list=new ArrayList<>();
        solve(nums,list,0);
        Collections.sort(list);
        System.out.println(list);
        return list.get(list.size()-1);
      

        





        
    }
}