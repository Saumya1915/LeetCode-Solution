class Solution {
    class Pair{
        int value;
        int index;

        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public int maxDistance(List<List<Integer>> arrays) {
       int mini=arrays.get(0).get(0);
       int index=0;
       int maxdiff=0;
       int size=arrays.get(0).size();
       int maxi=arrays.get(0).get(size-1);
       for(int i=1;i<arrays.size();i++)
       {
            int first=arrays.get(i).get(0);
            int last=arrays.get(i).get(arrays.get(i).size()-1);
            maxdiff=Math.max(maxdiff,Math.max(Math.abs(last-mini),Math.abs(first-maxi)));
            mini=Math.min(first,mini);
            maxi=Math.max(last,maxi);


       }
       return maxdiff;
         

    }
}