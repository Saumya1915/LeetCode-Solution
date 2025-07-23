class Solution {
    public int[][] diagonalSort(int[][] mat) {

        for(int i=0;i<mat[0].length;i++){
            int index=i;
            int j=0;
            ArrayList<Integer>list=new ArrayList<>();
            while(index<mat[0].length && j<mat.length){
                list.add(mat[j++][index++]);
            }
            Collections.sort(list);
            //System.out.println(list);
            index=i;
            j=0;
            int index1=0;
            while(index<mat[0].length && j<mat.length){
                mat[j][index]=list.get(index1++);
                j++;
                index++;
            }
        }

        for(int i=1;i<mat.length;i++){
            int index=i;
            int j=0;
            ArrayList<Integer>list=new ArrayList<>();
            while(index<mat.length && j<mat[0].length){
                list.add(mat[index++][j++]);
            }
            Collections.sort(list);
            index=i;
            j=0;
            int index1=0;
            while(index<mat.length && j<mat[0].length){
                mat[index][j]=list.get(index1++);
                j++;
                index++;
            }
        }
        return mat;
        
    }
}