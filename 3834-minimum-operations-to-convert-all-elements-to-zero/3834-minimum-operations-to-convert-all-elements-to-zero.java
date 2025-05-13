class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int num : nums) {
            while (!stack.isEmpty() && num < stack.peek()) {
                stack.pop();  // Invalidate larger numbers for current context
            }
            if (stack.isEmpty() || num > stack.peek()) {
                if (num > 0) ans++;
                stack.push(num);
            }
        }

        return ans;
    }
}