class Solution {
    char parent[]=new char[26];

    char findParent(char n){
        if(n==parent[n-'a']){
            return n;
        }
        return parent[n-'a']=findParent(parent[n-'a']);
    }

    void union(char ch1,char ch2){

        char parent1=findParent(ch1);
        char parent2=findParent(ch2);
        if(parent1>parent2){
            parent[parent1-'a']=parent2;
        }
        else{
            parent[parent2-'a']=parent1;

        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(char i='a';i<='z';i++){
            parent[i-'a']=i;
        }
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i),s2.charAt(i));
        }
        String str="";
        for(int i=0;i<baseStr.length();i++){
            str+=findParent(baseStr.charAt(i));
        }
        return str;


    }
}