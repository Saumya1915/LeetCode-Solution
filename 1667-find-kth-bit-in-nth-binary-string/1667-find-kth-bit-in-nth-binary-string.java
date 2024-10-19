class Solution {
    public String invertReverse(String str){
        char array[]=str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]=='1'){
                array[i]='0';
            }
            else{
                array[i]='1';
            }
        }
        int start=0;
        int end=array.length-1;
        while(start<=end){
            char temp=array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }

        return String.valueOf(array);


    }
    public String solve(int n){
        if(n==1){
            return "0";
        }
        String str=solve(n-1);
        String ans=str+"1"+ invertReverse(str);
        return ans;
    }
    public char findKthBit(int n, int k) {
        String str=solve(n);
        return str.charAt(k-1);
    }
}