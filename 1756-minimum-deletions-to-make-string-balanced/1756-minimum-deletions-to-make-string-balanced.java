class Solution {
    public int minimumDeletions(String s) {
     
       if(s.length()==0){
         return 0;
       }
       int countB=0;
       int removal=0;
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                if(countB>0){
                    countB--;
                    removal++;
                }
            }
            else{
                countB++;
            }
       }
       return removal;

        
    }
}