package com.zsi;

public class FindMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            int firstGoal = (length / 2) - 1;
            int secondGoal = (length / 2);
            return (findIndex(firstGoal, nums1, nums2) + findIndex(secondGoal, nums1, nums2)) / 2;
        } else {
            int goal = length / 2;
            return findIndex(goal, nums1, nums2);
        }
    }

    private double findIndex(int indexGoal, int[] nums1, int[] nums2) {
        IntArraySlice a = new IntArraySlice(nums1);
        IntArraySlice b = new IntArraySlice(nums2);

        Integer tryingWithA = findExactIndex(indexGoal, a.nums, a.l, a.r, b);

        if (tryingWithA == null) {
            a = new IntArraySlice(nums1);
            b = new IntArraySlice(nums2);

            Integer shouldHaveBeenHere = findExactIndex(indexGoal, b.nums, b.l, b.r, a);
            return shouldHaveBeenHere;
        }

        return tryingWithA;
    }

    public static Integer findExactIndex(int goalIndex, int[] nums, int l, int r, IntArraySlice b) {
        int midpointIndex = ((r - l) / 2) + l;

        int result = midpointIndex + getNumElementsToLeft(nums[midpointIndex], b);

        if (goalIndex == result) {
            return nums[midpointIndex];
        }

        // So if 11 matches 10, then you know that 

        if (l == r) {
            return null;
        }

        if (result < goalIndex) {
            int newLeft = midpointIndex + 1;
            return findExactIndex(goalIndex, nums, newLeft, r, b);
        } else {
            int newRight = midpointIndex;
            return findExactIndex(goalIndex, nums, l, newRight, b);
        } 
    }

    public static int getNumElementsToLeft(double goal, IntArraySlice nums) {
        if (goal < nums.nums[nums.l]) {
            return 0;
        }

        if (nums.nums[nums.r] < goal) {
            return nums.r - nums.l + 1;
        }

        int result = findIndexBinarySearchLeft(goal, nums.l, nums.r, nums.nums);
        return (result - nums.l) + 1;
    }

    public static int findIndexBinarySearchLeft(double goal, int l, int r, int[] nums) {
        if (r < l) {
            return -1;
        }

        int midpointIndex = ((r - l) / 2) + l;
        int midpoint = nums[midpointIndex];
        if (midpoint < goal) {
            int result = findIndexBinarySearchLeft(goal, midpointIndex + 1, r, nums);

            return Math.max(result, midpointIndex);
        } else if (midpoint > goal) {
            int result = findIndexBinarySearchLeft(goal, l, midpointIndex - 1, nums);
            return result;
        } else {
            return midpointIndex;
        }
    }

    public static int getNumElementsToRight(double goal, IntArraySlice nums) {
        if (goal < nums.nums[nums.l]) {
            return nums.r - nums.l + 1;
        }

        if (nums.nums[nums.r] < goal) {
            return 0;
        }

        int result = findIndexBinarySearchLeft(goal, nums.l, nums.r, nums.nums);
        return nums.r - (result + 1) + 1;
    }

    public static class IntArraySlice {
        public int l;
        public int r;

        private final int[] nums;

        public IntArraySlice(int[] nums) {
            this.l = 0;
            this.r = nums.length - 1;
            this.nums = nums;
        }

        public int getElementsToLeft() {
            return midpoint() - l;
        }

        public int getElementsToRight() {
            return r - midpoint();
        }

        public int midpoint() {
            return ((r + l) / 2);
        }

        public double mid() {
            return this.nums[midpoint()];
        }
    }
}
