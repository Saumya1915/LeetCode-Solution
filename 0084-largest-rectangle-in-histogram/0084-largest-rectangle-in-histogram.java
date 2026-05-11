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
}