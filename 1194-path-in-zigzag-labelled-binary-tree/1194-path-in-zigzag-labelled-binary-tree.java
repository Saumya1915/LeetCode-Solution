class Solution {
    public List<Integer> pathInZigZagTree(int label) {
    
    int level=1;
    int num=1;
    while(label>=num){
        num<<=1;
        level++;
    }
    level--;
    List<Integer> list=new ArrayList<>();
    while(label!=0){
        list.add(label);
        int maxi=(int)Math.pow(2,level)-1;
        int mini=(int)Math.pow(2,level-1);
        label=(int)((maxi+mini-label)/2);
        level--;
        

    }
    Collections.reverse(list);
    return list;

        

    }
}