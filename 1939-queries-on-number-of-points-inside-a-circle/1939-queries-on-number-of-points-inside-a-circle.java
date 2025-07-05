class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int radius=queries[i][2];
            for(int j=0;j<points.length;j++){
                int x1=points[j][0];
                int y1=points[j][1];
                int a=(int)Math.pow((x-x1),2);
                int b=(int)Math.pow((y-y1),2);
                int result=(int)Math.pow(radius,2);
                if(a+b<=result){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
}