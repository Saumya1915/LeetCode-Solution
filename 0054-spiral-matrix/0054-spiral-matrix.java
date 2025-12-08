class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer>list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;

        int startRow=0;
        int endRow=n-1;
        int startCol=0;
        int endCol=m-1;

        int total=m*n;

        int count=0;

        while(count<total){

            for(int i=startCol;count<total && i<=endCol;i++){
                list.add(matrix[startRow][i]);
                count++;
            }
            startRow++;

            for(int i=startRow; count<total && i<=endRow;i++){
                list.add(matrix[i][endCol]);
                count++;
            }
            endCol--;

            for(int i=endCol;count<total && i>=startCol;i--){
                list.add(matrix[endRow][i]);
                count++;
            }
            endRow--;

            for(int i=endRow; count<total && i>=startRow;i--){
                list.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        return list;
    }
}