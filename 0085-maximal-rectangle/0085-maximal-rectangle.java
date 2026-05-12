class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack=new Stack<>();
        int maxi=0;
        int n=heights.length;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                int element=stack.pop();
                maxi=Math.max(maxi,heights[element]*(i-(stack.isEmpty()?-1:stack.peek())-1));


            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int element=stack.pop();
           maxi=Math.max(maxi,heights[element]*(n-(stack.isEmpty()?-1:stack.peek())-1));


        }
        return maxi;
    }
    public int maximalRectangle(char[][] matrix) 
    {
        int matrix1[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    matrix1[i][j]=1;
                }
                else{
                    matrix1[i][j]=0;
                }
            }
        }

        int maxi=largestRectangleArea(matrix1[0]);
        for(int i=1;i<matrix1.length;i++){
            
            for(int j=0;j<matrix1[0].length;j++){
                if(matrix1[i][j]==1){
                    matrix1[i][j]+=matrix1[i-1][j];
                }
            }
            maxi=Math.max(maxi,largestRectangleArea(matrix1[i]));
        }
        return maxi;
         
    }
    
}