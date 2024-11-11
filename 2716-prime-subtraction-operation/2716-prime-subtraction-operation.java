class Solution {
    public boolean primeSubOperation(int[] nums) {
        
        boolean array[]=new boolean[10001];

        Arrays.fill(array,true);
        array[0]=array[1]=false;

        for(int i=2;i<10001;i++){
            for(int j=i*2;j<1001;j+=i){
                array[j]=false;
            }
        }

        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<1001;i++){
            if(array[i]){
                list.add(i);
            }
        }
        int prev=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){

            if(nums[i]<prev){
                prev=nums[i];
                continue;
            }
            int flg=0;
            for(int j=0;j<list.size() && list.get(j)<nums[i];j++){
                if(nums[i]-list.get(j)<prev){
                    prev=nums[i]-list.get(j);
                    flg=1;
                    break;
                }
            }
            if(flg==0){
                return false;
            }
        }
        return true;



    }
}