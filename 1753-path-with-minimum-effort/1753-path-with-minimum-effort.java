class Solution {
    class Pair{

        int effort;
        int x;
        int y;

        Pair(int effort,int x,int y){
            this.effort=effort;
            this.x=x;
            this.y=y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
       int array[][]=new int[heights.length][heights[0].length];

       for(int i=0;i<array.length;i++)
       {
        for(int j=0;j<array[0].length;j++)
        {
            array[i][j]=(int)(1e9);
        }
       }
       array[0][0]=0;
       PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->(a.effort-b.effort)); 
       pq.add(new Pair(0,0,0));
       while(!pq.isEmpty())
       {

        Pair p=pq.remove();
        int x=p.x;
        int y=p.y;
        int effort=p.effort;

        int[][] dis={{1,0},{-1,0},{0,-1},{0,1}};
        for(int[] dist:dis){
            int newx=x+dist[0];
            int newy=y+dist[1];
            
            if(newx>=0 && newx<heights.length && newy>=0 && newy<heights[0].length){
                int num=Math.abs(heights[x][y]-heights[newx][newy]);
                int effort2=Math.max(effort,num);
                if(array[newx][newy]>effort2){
                    array[newx][newy]=effort2;
                    pq.add(new Pair(effort2,newx,newy));

                }
            }
        }
       }
       return array[heights.length-1][heights[0].length-1];


    }
}