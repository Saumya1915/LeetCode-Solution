class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                count5++;
            }
            else if(bills[i]==10){
                    count10++;
                    count5--;
            
                
            }
            else if(bills[i]==20){
                count20++;
                if(count10!=0 && count5!=0 ){
                   count10--;
                   count5--;
                }
                else{
                    count5-=3;
                }
            }
            if(count5<0){
                return false;
            }
        }
        return true;
        
    }
}