class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){

            pq.add((long)nums[i]);
        }
        int sum=0;
        while(pq.size()>1){
              long num1=pq.remove();
              if(num1>=k){
                return sum;
              }
              long num2=pq.remove();
              
              long ans=Math.min(num1,num2)*2+Math.max(num1,num2);
              pq.add(ans);
              sum++;
        }
        return sum;
    }
}