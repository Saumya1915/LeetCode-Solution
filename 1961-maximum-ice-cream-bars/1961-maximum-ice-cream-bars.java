class Solution {
    public boolean solve(int mid,int[] costs, int coins ){
        int sum=0;
        for(int i=0;i<mid;i++){
            if(sum+costs[i]<=coins){
                sum+=costs[i];
            }
            else{
                return false;
            }
        }
        return true;
    }
    public int maxIceCream(int[] costs, int coins) {

       int start=0;
       int end=costs.length;
       int ans=0;
       Arrays.sort(costs);
       if(coins<costs[0]){
        return ans;
       }
       while(start<=end)
       {
           
           int mid=start+(end-start)/2;

           if(solve(mid,costs,coins)){
             ans=mid;
             start=mid+1;
           }
           else{
            end=mid-1;
           }
        }
        return ans; 
    }
}