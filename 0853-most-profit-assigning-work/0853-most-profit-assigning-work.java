class Solution {
    public int binarySearch(int array[], int num){
        int start=0;
        int end=array.length-1;
        int mid=start+(end-start)/2;
        if(num<array[0]){
            return -1;
        }
        int ans=-1;
        while(start<=end){
            if(array[mid]<=num){
                ans=array[mid];
                start=mid+1;
            }
            else{
                end=mid-1;
            }
            mid=start+(end-start)/2;
        }
        return ans;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<difficulty.length;i++){
            if(!map.containsKey(difficulty[i])){
                map.put(difficulty[i],profit[i]);
            }
            else{
                int count=map.get(difficulty[i]);
                if(count<profit[i]){
                    map.put(difficulty[i],profit[i]);
                }
            }
        }
        
        Arrays.sort(difficulty);
        int max=0;
        for(int i=0;i<profit.length;i++){
            int n=difficulty[i];
            max=Math.max(max,map.get(n));
            map.put(n,max);
        }
       
        int sum=0;
        for(int i=0;i<worker.length;i++){
            int num=worker[i];

            int num2=binarySearch(difficulty,num);
           
            if(num2!=-1){
                sum+=map.get(num2);
            }
           

        }
        return sum;

        


    }
}