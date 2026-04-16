class Solution {
    public void solve(int index,List<Integer>ans,List<List<Integer>>list,
    int[] candidates,int target,int sum){

        if(sum>target || index>=candidates.length){
            return;
        }

        if(sum==target){
            list.add(new ArrayList<>(ans));
            return;
        }

        //take
        ans.add(candidates[index]);
        solve(index,ans,list,candidates,target,sum+candidates[index]);
        ans.remove(ans.size()-1);

        //not take
        solve(index+1,ans,list,candidates,target,sum);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        solve(0,ans,list,candidates,target,0);
        return list;
         
    }
}