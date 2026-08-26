class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String str="";
        int start=0;
        int end=0;
        int mini=Integer.MAX_VALUE;
        int count=0;
        while(end<s.length())
        {
            if(s.charAt(end)=='1'){
                count++;
            }

            while(count==k)
            {
                if(mini>(end-start+1)){
                    str=s.substring(start,end+1);
                    mini=end-start+1;
                }
                else if(mini==(end-start+1) && (str.compareTo(s.substring(start,end+1))>0)){
                    str=s.substring(start,end+1);
                }
                if(s.charAt(start)=='1'){
                    count--;
                }
                start++;
            }
            end++;

        }
        return str;
    }
}