class TreeAncestor {
    int array[][];
    public TreeAncestor(int n, int[] parent) {
        array=new int[17][n];
        for(int j=0;j<n;j++){
              array[0][j]=parent[j];         
        }

        for(int i=1;i<17;i++)
        {
            
            for(int j=0;j<n;j++)
            {
                if(array[i-1][j]==-1){
                    array[i][j]=-1;
                }
                else
                array[i][j]=array[i-1][array[i-1][j]];
            }
        }              

        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array[0].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }


        
    }
    
    public int getKthAncestor(int node, int k) {
         for(int i=0;i<17;i++){
            int mask=1<<i;
            if((k&mask)>0){
                node=array[i][node];
                if(node==-1){
                    return -1;
                }
            }
         }
         return node;
        
        
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */