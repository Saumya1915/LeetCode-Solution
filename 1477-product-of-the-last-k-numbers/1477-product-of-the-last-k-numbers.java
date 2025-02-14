class ProductOfNumbers {
    int prev;
    ArrayList<Integer> list;
    public ProductOfNumbers() {
       list=new ArrayList<>();
       list.add(1);
       prev=1; 
    }
    
    public void add(int num) {
        if(num>0){
            prev*=num;
            list.add(prev);
        }
        else{
            list=new ArrayList<>();
            list.add(1);
            prev=1;
        }
    }
    
    public int getProduct(int k) {
       int n=list.size();
        if(k>=n){
            return 0;

        }
        return prev/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */