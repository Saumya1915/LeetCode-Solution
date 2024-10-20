class Solution {
    public boolean valid(int array[],int k){

            for(int i=0;i<array.length;i++){

                if(array[i]>=k){
                    return true;
                }
            }
            return false;
        }
    public int numberOfSubstrings(String s, int k) {
        int array[]=new int[26];
        int sum=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            array[index]++;
            while(valid(array,k)){
                sum+=s.length()-i;
                array[s.charAt(count)-'a']--;
                count++;
            }
        }
        
        return sum;
    }
}