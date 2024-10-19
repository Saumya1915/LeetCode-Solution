class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int distance=Integer.MIN_VALUE;
        for(int house:houses){
            int index=binarySearch(heaters,house);
            distance=Math.max(distance,Math.abs(heaters[index]-house));
            System.out.println(distance);

        }
        return distance;
    }

    public int binarySearch(int heaters[],int house){

        int start=0;
        int end=heaters.length-1;
        int result=0;
        while(start<=end){
        int mid=start+(end-start)/2;

        if(Math.abs(heaters[mid]-house)<Math.abs(heaters[result]-house)){
            result=mid;
        }
        if(heaters[mid]==house){
            return mid;
        }
        else if(heaters[mid]<house){
            start=mid+1;
        }
        else{
            end=mid-1;
        }
        }
        return result;

    }
}