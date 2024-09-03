class Solution {
    public int getLucky(String s, int k) {
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);
            int num=ch-'a'+1;
            stb.append(String.valueOf(num));


        }
        String str=stb.toString();
        int ans=0;
        for(int i=0;i<k;i++){
            int num=0;
             for(int j=0;j<str.length();j++){
               num+=str.charAt(j)-'0';
             }
             ans=num;
             str=String.valueOf(num);
        }
        return ans;
    }        
}