class Solution {
    public int findKthLargest(int[] nums, int k) {
        int offset = 10000;
        int[] count = new int[20001];

        for (int num : nums) {
            count[num + offset]++;
        }

        for (int i = 20000; i >= 0; i--) {
            if (count[i] == 0) {
                continue;
            }

            if (k > count[i]) {
                k -= count[i];
            } else {
                return i - offset;
            }
        }

        return -1;
    }
}