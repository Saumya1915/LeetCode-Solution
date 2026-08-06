class Solution {
    public int solve(int x,int y,int m,int n,int array[][]){
        if(x==0 && y==0){
            return 1;
        }
        if(x<0 || y<0){
            return 0;
        }
        if(array[x][y]!=-1){
            return array[x][y];
        }

        int down=solve(x-1,y,m,n,array);
        int right=solve(x,y-1,m,n,array);
        return array[x][y]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int array[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(array[i],-1);
        }
        return solve(m-1,n-1,m,n,array);
    }
}