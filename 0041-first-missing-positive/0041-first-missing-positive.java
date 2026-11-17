
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number at its correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: All numbers from 1 to n are present
        return n + 1;
    }
}
