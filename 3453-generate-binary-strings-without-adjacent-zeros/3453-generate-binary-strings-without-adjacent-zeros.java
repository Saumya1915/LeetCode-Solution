class Solution {
    public void solve(List<String>ans,int index,StringBuilder sb){
        if(index<0){
            ans.add(sb.toString());
            return;
        }
        solve(ans,index-1,sb);
        if(index==sb.length()-1||sb.charAt(index+1)!='0'){
            sb.setCharAt(index,'0');
            solve(ans,index-1,sb);
            sb.setCharAt(index,'1');
        }
    }
    public List<String> validStrings(int n) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("1");
        }
        solve(ans,sb.length()-1,sb);
        return ans;
        
    }
}