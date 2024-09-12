class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
       int allowed1[]=new int[26];
        int count=0;
        for(int i=0;i<allowed.length();i++){
            int a=allowed.charAt(i)-'a';
            allowed1[a]++;
        }
        for(int i=0;i<words.length;i++){
            boolean iscorrect=true;
            for(int j=0;j<words[i].length();j++)
            {
                
                
                if(allowed1[words[i].charAt(j)-'a']==0){
                    iscorrect=false;
                    break;
                }
                
                
            }
            if(iscorrect)
            count++;
            
            
            
        }
        return count;
        
        
       
    }
}