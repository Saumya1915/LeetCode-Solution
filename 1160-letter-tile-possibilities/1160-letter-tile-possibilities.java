class Solution {
    public StringBuilder swap(int index,int i,StringBuilder str){
        char temp=str.charAt(index);
        str.setCharAt(index, str.charAt(i));
        str.setCharAt(i, temp);
        return str;

    }
    public void permutation(HashSet<String>set,StringBuilder str,int index){

        if(index==str.length()){
            set.add(str.toString());
            return;
        }
        for(int i=index;i<str.length();i++){

            str=swap(index,i,str);
            permutation(set,str,index+1);
            str=swap(index,i,str);
        }

    }
    public void solve(HashSet<String> set,String tiles,StringBuilder str,int index){

        if(index==tiles.length()){
            if(str.length()==1){
                set.add(str.toString());
            }
            if(str.length()>1){
                permutation(set,str,0);
            }
            return;
        }

        solve(set,tiles,str,index+1);

        str.append(tiles.charAt(index));
        solve(set,tiles,str,index+1);
        str.deleteCharAt(str.length()-1);
    }
    public int numTilePossibilities(String tiles) {
        HashSet<String> set=new HashSet<>();
        StringBuilder str=new StringBuilder();
        solve(set,tiles,str,0);
        System.out.println(set);
        return set.size();




        
        
    }
}