class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        ArrayList<int[]> list=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){

            if(intervals[i][0]<=end){

                end=Math.max(intervals[i][1],end);
            }
            else{
                int[] array=new int[2];
                array[0]=start;
                array[1]=end;
                list.add(array);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        int[] array=new int[2];
        array[0]=start;
        array[1]=end;
        list.add(array);
        return list.toArray(new int[list.size()][]);

    }
}