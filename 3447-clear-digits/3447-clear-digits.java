class Solution {
    public String clearDigits(String s) {
        Stack<Character>stack=new Stack<>();

        for(int i=0;i<s.length();i++)
        {

            if(!stack.isEmpty() && Character.isDigit(s.charAt(i))){

                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }

        }
        StringBuilder str=new StringBuilder();
        // if(stack.isEmpty()){
        //     return "";
        // }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
        
    }
}