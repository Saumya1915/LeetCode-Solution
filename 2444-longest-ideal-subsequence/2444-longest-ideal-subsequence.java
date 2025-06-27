class Solution {
    public int longestIdealString(String s, int k) {
        int len[]=new int[26];
        int maxi=1;
        for(int i=0;i<s.length();i++)
        {
            len[s.charAt(i)-'a']++;
            int num=s.charAt(i)-'a';
            for(int j=Math.max(0,num-k);j<=Math.min(25,num+k);j++)
            {
                if(num!=j)
                    len[num]=Math.max(len[num],len[j]+1);

                
            }
            maxi=Math.max(maxi,len[num]);

            
        }
        // for(int a:len){
        //         System.out.println(a);
        //     }
        return maxi;
    }
}