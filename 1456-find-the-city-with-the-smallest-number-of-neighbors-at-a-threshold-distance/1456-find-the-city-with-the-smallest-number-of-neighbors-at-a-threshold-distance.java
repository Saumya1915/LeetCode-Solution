class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
        

        int array[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {
                if(i==j){
                    array[i][j]=0;
                }
                else{

                array[i][j]=(int)(1e9);}
            }

        }

        for(int i=0;i<edges.length;i++)
        {

            int x=edges[i][0];
            int y=edges[i][1];
            int z=edges[i][2];

            array[x][y]=z;
            array[y][x]=z;
        }

        for(int via=0;via<n;via++)
        {

            for(int i=0;i<n;i++)
            {

                for(int j=0;j<n;j++){

                    int cost=array[i][via]+array[j][via];
                    array[i][j]=Math.min(cost,array[i][j]);
                }
            }
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=0;j<n;j++)
            {

                if(array[i][j]<=distanceThreshold){
                    sum++;
                }


            }
            ans[i]=sum;
        }
        int index=0;
        for(int i=1;i<n;i++){
           if(ans[index]>=ans[i]){

                index=i;
           }
        }
        System.out.print(ans[index]+" ");

        return index;


        


        
        
    }
}