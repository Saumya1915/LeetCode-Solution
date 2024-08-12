class KthLargest
{
    PriorityQueue<Integer> q;
    final int k;
    int third=Integer.MIN_VALUE;
    public KthLargest(int k, int[] nums)
    {
        this.k=k;
       q=new PriorityQueue<>(k);
       for(int a:nums){
           add(a);
       }
       //System.out.println(q);


    }
    
    public int add(int val) 
    {
       if(q.size()<k){
           q.add(val);
       }
       else if(q.peek()<val){
           q.poll();
           q.add(val);
       }
       return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */