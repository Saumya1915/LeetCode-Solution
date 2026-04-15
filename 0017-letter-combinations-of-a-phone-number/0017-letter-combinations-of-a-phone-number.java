class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String>map=new HashMap<>();

        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String>list=new ArrayList<>();
        int n=digits.charAt(0)-'0';
        String str=map.get(n);
        for(int i=0;i<str.length();i++){
            list.add(String.valueOf(str.charAt(i)));
        }

        for(int i=1;i<digits.length();i++)
        {
            int n1=digits.charAt(i)-'0';
            String str1=map.get(n1);
            int n2=list.size();
            for(int j=0;j<n2;j++){
                String ans=list.get(j);
                for(int k=0;k<str1.length();k++){
                    String s3=ans+String.valueOf(str1.charAt(k));
                    list.add(s3);
                }
            }
            int j=0;
            while(n2>0){
               list.remove(j);
               n2--;
            }

        }
        return list;
        
    }
}