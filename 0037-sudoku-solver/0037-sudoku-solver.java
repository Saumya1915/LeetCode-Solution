class Solution {
    public boolean solveSudoku(char[][] board)
     {
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char m='1';m<='9';m++)
                    {
                        if(isPossible(m,i,j,board))
                        {
                            board[i][j]=m;

                            if(solveSudoku(board)==true){
                                return true;
                            }
                            else
                            {

                                board[i][j]='.';

                            }
                        }
                        
                    }
                    return false;
                }
                
            }
        }
        return true;
    }

    public boolean isPossible(char c,int i,int j,char board[][])
    {

        for(int k=0;k<9;k++)
        {
            if(board[i][k]==c){
                return false;
            }
            if(board[k][j]==c){
                return false;
            }
            if(board[3*(i/3)+k /3][3*(j/3)+k%3]==c){
                return false;
            }
        }
        return true;
    }
}