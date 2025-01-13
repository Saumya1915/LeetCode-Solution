class Solution {
    public int minimumLength(String s) {
        int array[]=new int[26];
        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'a';
            if(array[num]==2){
                array[num]=1;
            }
            else{
                array[num]++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
              //System.out.print
              count+=array[i];
        }
        return count;
    }
}