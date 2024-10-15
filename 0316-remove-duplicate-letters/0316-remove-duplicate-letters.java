class Solution {
    public String removeDuplicateLetters(String s) {
       boolean array[]=new boolean[26];
       int last[]=new int[26];

       for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         int index=s.lastIndexOf(ch);
         last[ch-'a']=index;
       } 

       Stack<Character>stack=new Stack<>();
       for(int i=0;i<s.length();i++)
       {

        if(array[s.charAt(i)-'a']==true){
            continue;
        }

        while(!stack.isEmpty() && stack.peek()>s.charAt(i) && last[stack.peek()-'a']>i){
            array[stack.pop()-'a']=false;
        }
            stack.push(s.charAt(i));
            array[s.charAt(i)-'a']=true;
       }

       StringBuilder str=new StringBuilder();
       while(!stack.isEmpty()){
        str.append(stack.pop());
       }

       return str.reverse().toString();
    }
}