class NumArray {

    int prefixSum[];
    public NumArray(int[] nums) {
        prefixSum = nums;
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i] + prefixSum[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */