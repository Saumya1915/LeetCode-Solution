class Solution {
    public int binarySearch(int target,int array[]){

        int start=0;
        int end=array.length-1;
        if(array[0]>target){
            return -1;
        }
        int ans=-1;
        while(start<=end)
        {
             
             int mid=start+(end-start)/2;

             if(array[mid]<=target){
                 ans=mid;
                 start=mid+1;

             }
             else{
                end=mid-1;
             }

             
        }
        return ans;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<difficulty.length;i++){
            if(!map.containsKey(difficulty[i])){
                map.put(difficulty[i],profit[i]);
            }
            else{
                int count=map.get(difficulty[i]);
                if(profit[i]>count){
                    map.put(difficulty[i],profit[i]);
                }
            }
        }
        Arrays.sort(difficulty);
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<difficulty.length;i++){

            maxi=Math.max(maxi,map.get(difficulty[i]));
            profit[i]=maxi;
        }
        int sum=0;

        for(int i=0;i<worker.length;i++){

            int num=binarySearch(worker[i],difficulty);
            if(num!=-1){
                sum+=profit[num];
            }
        }
        return sum;
    }
}