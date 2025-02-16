class Solution {
    boolean flag=false;
    public void solve(int index,int[] array,int[] visited,int n)
   {
    while (index < array.length && array[index] != 0) {
            index++;
    }
    if(index==array.length){
        flag=true;
        return;
    }
    for(int i=n;i>=1;i--)
    {
        if (visited[i] == 1) continue;
        if(i==1)
        {
            array[index]=1;
            visited[1]=1;
            solve(index+1,array,visited,n);
            if(flag){ return;}
            visited[1]=0;
            array[index]=0;
            
        }
        else{
            if (index + i < array.length && array[index + i] == 0) {
                array[index]=i;
                array[index+i]=i;
                visited[i]=1;
                solve(index+1,array,visited,n);
                if(flag){ return;}
                visited[i]=0;
                array[index]=0;
                array[index+i]=0;
                }
                
        }

    }
}
    public int[] constructDistancedSequence(int n) {
         int size = 2 * n - 1;
        int[] array = new int[size];
        int[] visited = new int[n + 1];
        solve(0, array, visited, n);
        return array;
        
    }
}