class Solution {
    public int[] finalPrices(int[] prices) {
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]<=prices[i]){
                    int diff=prices[i]-prices[j];
                    prices[i]=diff;
                    break;
                }
            }
        }
        return prices;
    }
}