class Solution {
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        int array[]=new int[n];
        array[0]=1;
        int c2=0;
        int c3=0;
        int c5=0;

        for(int i=1;i<n;i++){
          int mini=Math.min(2*array[c2],Math.min(3*array[c3],5*array[c5]));
          array[i]=mini;
          if(mini==2*array[c2]){
              c2++;
          }
          if(mini==3*array[c3]){
              c3++;
          }
          if(mini==5*array[c5]){
              c5++;
          }
          
          
        }
        return array[n-1];

      
    }
}