class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
        
       for(int i=0;i<words.length;i++){
           String s=words[i];
          
           if(s.contains(pref)){
               boolean result=true;
               for(int j=0;j<pref.length();j++){
                   if(s.charAt(j)!=pref.charAt(j)){
                       result=false;
                       break;
                   }
               }
               if(result){
                   count++;
               }
           }
       }
        return count;
    }
}