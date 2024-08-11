class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int arr[][]=new int[rows][cols];
        ArrayList<int[]>array=new ArrayList<>();
        int total=rows*cols;
        int count=0;
        int index=0;
        int x=rStart;
        int y=cStart;
        int ans1[]={x,y};
        array.add(ans1);
        while(array.size()<total)
        {
             count++;
             for(int i=0;i<count && array.size()<total ;i++){
                y++;
                if(x>=0 && x<rows && y>=0 && y<cols){
                    int ans[]={x,y};
                    array.add(ans);              
                    }
             }
             for(int i=0;i<count && array.size()<total ;i++){
                x++;
                if(x>=0 && x<rows && y>=0 && y<cols){
                    int ans[]={x,y};
                    array.add(ans);
                    }
             }
             count++;
             for(int i=0;i<count && array.size()<total ;i++){
                y--;
                if(x>=0 && x<rows && y>=0 && y<cols){
                    int ans[]={x,y};
                    array.add(ans);
                }
             }
             for(int i=0;i<count && array.size()<total ;i++){
                x--;
                if(x>=0 && x<rows && y>=0 && y<cols){
                    int ans[]={x,y};
                    array.add(ans);
                }
             }
        }
        return array.toArray(new int[rows * cols][2]);
    }
}