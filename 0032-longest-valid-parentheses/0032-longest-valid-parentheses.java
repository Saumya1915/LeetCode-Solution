class Solution {
    public int longestValidParentheses(String s) {
       Stack<Integer> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && s.charAt(stack.peek())=='(' && s.charAt(i)==')'){
                stack.pop();
            }
            else{
                stack.push(i);
            }
        }
        int max=0;
        int count=s.length();
       
        while(!stack.isEmpty()){
            int a=stack.pop();
          max=Math.max(max,count-a-1);
          count=a;
        }
        if(stack.isEmpty()){
            max=Math.max(max,count);
        }
       

        return max;
    }
}