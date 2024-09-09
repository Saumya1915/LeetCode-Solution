class Solution {
    public boolean check(ArrayList<ArrayList<Integer>>list,int array[],int start,int color){
        array[start]=color;
        Queue<Integer>q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty())
        {
            int value=q.remove();
            int col=array[value];

            for(Integer it:list.get(value)){
                if(array[it]!=-1){
                    if(col==array[it]){
                        return false;
                    }
                }
                else{
                    array[it]=col==0?1:0;
                    q.add(it);
                }
            }
        }
        return true;

    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            
            int x=dislikes[i][0];
            int y=dislikes[i][1];

            list.get(x).add(y);
            list.get(y).add(x);
        }

        int array[]=new int[n+1];
        Arrays.fill(array,-1);
        for(int i=1;i<array.length;i++)
        {
            if(array[i]==-1){
                if(check(list,array,i,0)==false){
                    return false;
                }
            }
        }
        return true;


    }
}