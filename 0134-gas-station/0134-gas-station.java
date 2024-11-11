class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
        }
        if(sum<0){
            return -1;
        }
        int gastank=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            gastank+=gas[i]-cost[i];
            if(gastank<0){
                start=i+1;
                gastank=0;
            }
        }
        return start;
       
    }
}