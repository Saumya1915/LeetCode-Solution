class Solution {
    public int[][] sortTheStudents(int[][] score, int k) 
    {
        HashMap<Integer,Integer>map=new HashMap<>();
        int array[]=new int[score.length];
        int ans[][]=new int[score.length][score[0].length];
        for(int i=0;i<score.length;i++)
        {
            map.put(score[i][k],i);
            array[i]=score[i][k];

        }
        Arrays.sort(array); 
        int start=0;
        int end=array.length-1;
        while(start<=end){
            int temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        } 

        for(int i=0;i<array.length;i++){
            int index=map.get(array[i]);
                for(int j=0;j<score[0].length;j++){
                    ans[i][j]=score[index][j];
                }
            
        }
        return ans; 

    }
}