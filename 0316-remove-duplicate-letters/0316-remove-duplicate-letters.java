class Solution {
    public String removeDuplicateLetters(String s) {
        boolean array[]=new boolean[26];
        int lastIndex[]=new int[26];
        for(int i=0;i<s.length();i++){
            int index=s.lastIndexOf(s.charAt(i));
            lastIndex[s.charAt(i)-'a']=index;
        }
       Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(array[s.charAt(i)-'a']==true){continue;}
            while(!stack.isEmpty() && stack.peek()>s.charAt(i) && lastIndex[stack.peek()-'a']>i){
                array[stack.pop()-'a']=false;
        
             }
            stack.push(s.charAt(i));
            array[s.charAt(i)-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}