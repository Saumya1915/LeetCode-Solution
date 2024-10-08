class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty() && stack.peek()=='[' && s.charAt(i)==']'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        int open=0;
        while(!stack.isEmpty()){
            if(stack.pop()=='['){
                open++;
            }

        }
        if(open%2!=0){
            return (open+1)/2;
        }
        return open/2;
    }
}