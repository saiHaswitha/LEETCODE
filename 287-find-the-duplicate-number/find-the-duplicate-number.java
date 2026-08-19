class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> repeated = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (repeated.contains(nums[i])) {
                return nums[i];
            }
            repeated.add(nums[i]);
        }
        return -1;
    }
}