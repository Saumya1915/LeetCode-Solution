class Solution {
    public int maximum(int n){

        String str=String.valueOf(n);
        return str.length();
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            while(arr1[i]>0){
                set.add(arr1[i]);
                arr1[i]=arr1[i]/10;
            }
        }
        int maxi=0;
        for(int i=0;i<arr2.length;i++){

            while(arr2[i]>0){

                if(set.contains(arr2[i])){
                    
                    maxi=Math.max(maxi,maximum(arr2[i]));


                }
                arr2[i]/=10;
            }

        }
        return maxi;


    }
}