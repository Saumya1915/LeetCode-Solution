class Solution {
    public void generate(List<String> list, int open,int close,StringBuilder sb,int n){
        
        if(sb.length()==2*n && open==close){
            //System.out.println(sb.toString());
            list.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            generate(list,open+1,close,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(")");
            generate(list,open,close+1,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {

        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        generate(list,0,0,sb,n);
        return list;
    }
}