class Solution {
    
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int count[]=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t;i++)
        {
            
            int temp=count[25];
            for(int j=24;j>=0;j--){
                count[j+1]=count[j];
                count[j]=0;
            }
            count[0]=(count[0]+temp)%MOD;
            count[1]=(count[1]+temp)%MOD;

        }
        int ans=0;
        for(int i=0;i<26;i++){
            ans=(ans+count[i])%MOD;
        }
        return ans;
        
    }
}