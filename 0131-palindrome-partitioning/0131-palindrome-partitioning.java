class Solution {
    public boolean check(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void solve(List<List<String>>list,List<String>ans,int index,String s){
        if(index>s.length()){
            return;
        }
        if(index==s.length()){
            list.add(new ArrayList<>(ans));
            return;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=index;i<s.length();i++){
            sb.append(s.charAt(i));
            if(check(sb.toString()))
            {
                //System.out.println(sb.toString());
                ans.add(sb.toString());
                solve(list,ans,i+1,s);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>list=new ArrayList<>();
        List<String>ans=new ArrayList<>();
        solve(list,ans,0,s);
        return list;
    }
}