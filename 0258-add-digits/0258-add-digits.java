class Solution {
    int sum=0;
    public int addDigits(int num) {

        if(num==0){
            return 0;
        }
        sum=num%10+addDigits(num/10);
        if(sum>=10){
            num=sum;
            sum=0;
            addDigits(num);
        }
        return sum;

        
    }
}