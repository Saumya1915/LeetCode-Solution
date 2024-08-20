class Solution {
    long fuel=0;
    public int dfs(ArrayList<ArrayList<Integer>> list, int num, int array[],int seats){
        array[num]=1;
        int person=1;
        for(Integer it: list.get(num)){
            if(array[it]!=1 && it!=0){
                person+=dfs(list,it,array,seats);
            }
        }
        //System.out.println(Math.ceil(person/seats));
        if(person<=seats){
            fuel+=1;
        }
        else{
             fuel+=person/seats;
             if(person%seats!=0){
                fuel+=1;
             }
        }
        //System.out.println(fuel+"--->"+num);
        return person;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        for(int i=0;i<roads.length+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            int a=roads[i][0];
            int b=roads[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        //System.out.println(list);
        int array[]=new int[roads.length+1];
        for(int i=0;i<list.get(0).size();i++){
            dfs(list,list.get(0).get(i),array,seats);
        }
        return fuel;
    }
}