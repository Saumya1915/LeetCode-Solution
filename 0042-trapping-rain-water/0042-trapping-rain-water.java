class Solution {
    public int trap(int[] arr) {

        int maxLeft[]=new int[arr.length];
        
        int maxRight[]=new int[arr.length];
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<arr.length;i++){
            
            while(!stack.isEmpty() && arr[i]>stack.peek()){
                
                stack.pop();
            }
            
            if(stack.isEmpty()){
                stack.push(arr[i]);
                
            }
            maxLeft[i]=stack.peek();
            
        }
        // for(int a:maxLeft){
        //     System.out.print(a+" ");
        // }
        //return 0;
        
        stack=new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--)
        {
            
            while(!stack.isEmpty() && arr[i]>stack.peek()){
                
                stack.pop();
            }
            
            if(stack.isEmpty()){
                stack.push(arr[i]);
                
            }
            maxRight[i]=stack.peek();
            
        }
        // for(int a:maxRight){
        //   System.out.print(a+" ");
        // }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            
            sum=sum+Math.min(maxLeft[i],maxRight[i])-arr[i];
            
        }
        return sum;
        
    }
}