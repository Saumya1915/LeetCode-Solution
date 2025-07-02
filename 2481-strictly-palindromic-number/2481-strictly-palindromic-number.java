class Solution {
    public boolean isStrictlyPalindromic(int n) {
        String s=String.valueOf(n);
        for(int i=2;i<=n-2;i++)
        {
            String ans=Integer.toString(
            Integer.parseInt(s, 10), i);
            int start=0;
            int end=ans.length()-1;
            while(start<end)
            {
                if(ans.charAt(start)!=ans.charAt(end)){
                    return false;
                    
                }
                start++;
                end--;
            }
        }
        return true;
    }
}