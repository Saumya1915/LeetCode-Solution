class Solution {
    public String countAndSay(int n) {
        String ans="1";
        for(int i=1;i<n;i++)
        {

             StringBuilder sb=new StringBuilder();
             int j=0;
             int n1=ans.length();
             while(j<n1){
                int count=0;
                char ch=ans.charAt(j);
                while(j<n1 && ch==ans.charAt(j)){
                    j++;
                    count++;
                }
                sb.append(count);
                sb.append(ch);

             }
             ans=sb.toString();
        }
        return ans;

    }
}