class Solution {
    public boolean isPossible(int mid,int[] position,int m){
        int num=1;
        int lastPosition=position[0];
        for(int i=1;i<position.length;i++){
            if(Math.abs(position[i]-lastPosition)>=mid){
                num++;
                if(num==m){
                    return true;
                }
                lastPosition=position[i];
            }
            
            
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start=1;
        int end=position[position.length-1]-position[0];
         int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(mid,position,m)){
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