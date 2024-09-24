class NumArray {

    int nums[];
    public NumArray(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        
        /**
        [2-5]
        i[0-5] = i[0-1] + i[2-5]
        i[2-5] = i[0-5] - [0-1]
        i[2, 5] = i[5] - [1]
        i[i, j] = i[j] - [i - 1]
        */
        
        // calculate the sum(left, right);
        if(left == 0){
            return nums[right];
        }
        int sum = nums[right] - nums[left - 1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */