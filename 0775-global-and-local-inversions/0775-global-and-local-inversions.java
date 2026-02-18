class Solution {
    int count2=0;
    public int merge(int nums[],int start,int end){
        int mid=start+(end-start)/2;
        int left=mid-start+1;
        int right=end-mid;
        int mainIndex=start;
        int array[]=new int[left];
        int array2[]=new int[right];
        for(int i=0;i<array.length;i++){
            array[i]=nums[mainIndex++];
        }

        mainIndex=mid+1;
        for(int i=0;i<array2.length;i++){
            array2[i]=nums[mainIndex++];
        }

        int i=0;
        int j=0;
        int swaps=0;
        mainIndex=start;
        while(i<array.length && j<array2.length){

            if(array[i]>array2[j]){
                swaps += (left - i);;
                nums[mainIndex++]=array2[j++];
            }
            else{
                nums[mainIndex++]=array[i++];
            }
        }
        while(i<array.length){
            nums[mainIndex++]=array[i++];
        }

        while(j<array2.length){
            nums[mainIndex++]=array2[j++];
        }
        return swaps;



    }
    public void mergeSort(int nums[],int start,int end){

        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        count2+=merge(nums,start,end);
    }
    public boolean isIdealPermutation(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length-1;i++){

            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        

        mergeSort(nums,0,nums.length-1);

        System.out.println("count-----"+count);
        System.out.println("count2-----"+count2);

        if(count==count2){
            return true;
        }
        else{
            return false;
        }


    }
}