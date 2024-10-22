class Solution {
    class Pair {

        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new ArrayList<>();
        Pair[] array = new Pair[n];
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {

            array[i] = new Pair(nums[i], i);
        }

        merge(array, 0, n - 1, result);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            ans.add(result[i]);
        }

        return ans;
    }

    public void merge(Pair array[], int start, int end, int[] result) {

        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        merge(array, start, mid, result);
        merge(array, mid + 1, end, result);
        mergeSort(array, start, end, result);

    }

    public void mergeSort(Pair array[], int start, int end, int result[]) {

        int mid = start + (end - start) / 2;

        int length1 = mid - start + 1;
        int length2 = end - mid;
        Pair left[] = new Pair[length1];
        int mainIndex = start;
        for (int i = 0; i < length1; i++) {
            left[i] = array[mainIndex++];
        }
        mainIndex = mid + 1;
        Pair right[] = new Pair[length2];
        for (int i = 0; i < length2; i++) {

            right[i] = array[mainIndex++];
        }
        int i = 0;
        int j = 0;
        int nums = 0;
        mainIndex = start;
        while (i < length1 && j < length2) {

            if (left[i].val > right[j].val) {
                array[mainIndex++] = right[j];
                j++;
                nums++;
            } else {
                array[mainIndex++] = left[i];
                result[left[i].index] += nums;
                i++;
                
            }
        }

        while (i < length1) {
            result[left[i].index] += nums;
            array[mainIndex++] = left[i];

            i++;
            
        }
        while (j < length2) {

            array[mainIndex++] = right[j];
            j++;
        }
    }
}