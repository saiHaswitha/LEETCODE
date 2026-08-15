class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }

        // If total XOR is non-zero,
        // we can take the whole array.
        if (xor != 0) {
            return n;
        }

        // Total XOR is 0.
        // Check if there is at least one non-zero element.
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                return n - 1;
            }
        }

        // All elements are 0.
        return 0;
    }
}