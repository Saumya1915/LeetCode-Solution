class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        List<List<String>> ans=new ArrayList<>();
        Arrays.sort(products);

        int start=0;
        int end=products.length-1;
        
        String str="";
        for(int i=0;i<searchWord.length();i++)
        {
            
            str=str+searchWord.charAt(i);
            List<String> list=new ArrayList<>();

            while(start<=end){
                if(products[start].startsWith(str)){
                    break;
                }
                start++;
            }

            while(start<=end){
                if(products[end].startsWith(str)){
                    break;
                }
                end--;
            }
            //System.out.println(start+"    "+end);

            if(start>end){
                ans.add(list);
            }
            else{

                for(int j=start, count=0;j<=end && count<3;j++,count++)
                {

                    list.add(products[j]);

                }
                ans.add(list);
            }

            
        }
        return ans;
    }
}