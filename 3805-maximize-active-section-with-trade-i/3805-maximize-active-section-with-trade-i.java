class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int prev=0;
        int curr=0;
        int ones=0;
        int maxi=0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)=='0'){
                curr++;
            }
            else{
                if(curr!=0)prev=curr;
                curr=0;
                ones++;
                
            }
            maxi=Math.max(maxi,curr+prev);
            


        }
        if(maxi==prev || maxi==curr){
            return ones;
        }
        
        return ones+maxi;
    }
}