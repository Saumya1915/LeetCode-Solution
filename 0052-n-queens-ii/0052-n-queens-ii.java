class Solution {
    public boolean isSafe(int i,int j,int[][] chessboard,int n){

        //above
        int tempi=i;
        int tempj=j;
        while(tempi>=0)
        {
            if(chessboard[tempi][tempj]==1){
                return false;
            }
            tempi--;
        }

       

        //left diagonal
        tempi=i;
        tempj=j;
        while(tempi>=0 && tempj>=0){
            if(chessboard[tempi][tempj]==1){
                return false;
            }
            tempi--;
            tempj--;
        }

        


        //right diagonal
        tempi=i;
        tempj=j;
        while(tempi>=0 && tempj<n){

            if(chessboard[tempi][tempj]==1){
                return false;
            }
            tempi--;
            tempj++;

        }

        return true;
    }
    public void solve(List<List<String>>ans,int n, 
    int chessboard[][],int i){

        if(i==n)
        {
            List<String>output=new ArrayList<>();
            for(int l=0;l<n;l++)
            {
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<n;k++)
                {
                    if(chessboard[l][k]==0){
                        sb.append(".");
                    }
                    else{
                        sb.append("Q");
                    }
                }
                output.add(sb.toString());
            }
            ans.add(output);
            return;
        }

        for(int k=0;k<n;k++){
            if(isSafe(i,k,chessboard,n)){
                chessboard[i][k]=1;
                solve(ans,n,chessboard,i+1);
                chessboard[i][k]=0;
            }
        }

    }
    public int totalNQueens(int n) {
         List<List<String>>ans=new ArrayList<>();
        int chessboard[][]=new int[n][n];
        solve(ans,n,chessboard,0);
        return ans.size();
        
    }
}