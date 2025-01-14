class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] array=new int[A.length];
        ArrayList<Integer> listA=new ArrayList<>();
         ArrayList<Integer> listB=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            int count=0;
            listA.add(A[i]);
            listB.add(B[i]);
            for(int j=0;j<listA.size();j++){
                if(listB.contains(listA.get(j)))
                   {
                    count++;
                  }
            }
           array[i]=count;
            
        }
        return array;
    }
}