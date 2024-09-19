class Solution {
    class Pair{

        int x;
        int y;
        int distance;

        Pair(int x,int y,int distance){

            this.x=x;
            this.y=y;
            this.distance=distance;

        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0){
            return -1;
        }
       PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.distance-b.distance));
       int[][] visited=new int[grid.length][grid[0].length];
       pq.add(new Pair(0,0,0));
       while(!pq.isEmpty())
       {

           Pair p=pq.remove();
           int x=p.x;
           int y=p.y;
           int distance=p.distance;

           if(x==grid.length-1 && y==grid[0].length-1){
                  return distance+1;
           }

           int[][] dist={{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1}};

           for(int[] dis:dist){
            int newx=x+dis[0];
            int newy=y+dis[1];
            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length && visited[newx][newy]==0 && grid[newx][newy]==0)
            {
                visited[newx][newy]=1;
                pq.add(new Pair(newx,newy,distance+1));
            }
           }

       }
       return -1;


        
    }
}