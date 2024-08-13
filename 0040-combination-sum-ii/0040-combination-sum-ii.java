class Solution {
    int sum=0;
    public void solve(int[] candidates, List<List<Integer>> ans,int target,int index,List<Integer> list) {
         if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum>target || index==candidates.length){
            return;
        }
       
        list.add(candidates[index]);
        //System.out.println(list);
        sum+=candidates[index];
        solve(candidates,ans,target,index+1,list);
        sum-=candidates[index];
        list.remove(list.size()-1);
        //System.out.println(list);
        if(index<candidates.length-1 && candidates[index]==candidates[index+1]){
                while(index<candidates.length-1 && candidates[index]==candidates[index+1]){
                    index++;
                }
        }
        solve(candidates,ans,target,index+1,list);

        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        solve(candidates,ans,target,0,list);
        return ans;
    }
}