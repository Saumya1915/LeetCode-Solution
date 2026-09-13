class Solution {
    public int lastStoneWeightII(int[] stones) {

        int total=0;
        for(int i=0;i<stones.length;i++){
            total+=stones[i];
        }
        boolean array[][]=new boolean[stones.length][total+1];
        array[0][stones[0]]=true;
        for(int i=0;i<stones.length;i++){
            array[i][0]=true;
        }
        for(int i=1;i<stones.length;i++){
            for(int j=1;j<=total;j++){
                 
               boolean not=array[i-1][j];
               boolean take=false;
               if(stones[i]<=j){
                    take=array[i-1][j-stones[i]];
               } 
               array[i][j]=not||take; 

            }
        }
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<=total;i++){
            if(array[array.length-1][i]==true)
            diff=Math.min(diff, Math.abs(total-2*i));
            
        }
        return diff;

        
    }
}