package com.zsi;

public class FirstMissingPos {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] >= 1 && nums[i] != (i + 1)) {
                final int temp = nums[nums[i] - 1];
                if (temp == nums[i]) {
                    break;
                }

                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
