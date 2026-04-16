class Solution {
    public void solve(int index,List<Integer>ans,List<List<Integer>>list,
    int[] candidates,int target,int sum){

        if(sum==target){
            list.add(new ArrayList<>(ans));
            return;
        }

        if(sum>target || index>=candidates.length){
            return;
        }

        

        //take
        ans.add(candidates[index]);
        int newSum=sum+candidates[index];
        solve(index+1,ans,list,candidates,target,newSum);
        
        ans.remove(ans.size()-1);

        while (index+1  < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }

        //not take
        solve(index+1,ans,list,candidates,target,sum);

        

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,ans,list,candidates,target,0);
        return list;
        
    }
}