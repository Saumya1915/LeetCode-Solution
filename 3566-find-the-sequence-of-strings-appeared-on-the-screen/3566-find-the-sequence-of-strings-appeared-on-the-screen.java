class Solution {
    public List<String> stringSequence(String target) {
       List<String> list=new ArrayList<>();
       int i=0;
       StringBuilder sb=new StringBuilder();
       while(i<target.length())
       {
        sb.append('a');
        list.add(sb.toString());
        char ch=target.charAt(i);
        while(sb.charAt(sb.length()-1)!=ch)
        {
        char value=sb.charAt(sb.length()-1);
         value+=1;
        sb.deleteCharAt(sb.length()-1);
        sb.append(value);
        list.add(sb.toString());
         }
         i++;
       } 
       return list;
    }
}