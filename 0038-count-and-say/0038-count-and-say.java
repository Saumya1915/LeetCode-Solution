class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        int count=1;
        String str=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(str.charAt(i));
                count=1;
            }
        }
        sb.append(count);
        sb.append(str.charAt(str.length()-1));
        return sb.toString();
    }
}