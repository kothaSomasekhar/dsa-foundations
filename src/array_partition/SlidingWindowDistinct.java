package array_partition;

import java.util.HashSet;

public class SlidingWindowDistinct {


    public static long findMaxSubarraySum(int[] nums, int k) {
        // Implement your sliding window logic here
        if (nums == null || nums.length < k || k <= 0) {
            return 0;
        }
        int n = nums.length;
        long maxvalue = 0;
        int left = 0;
        long currsum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                currsum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currsum += nums[right];
            if ((right - left + 1) == k) {
                if (currsum > maxvalue) {
                    maxvalue = currsum;
                }
                    set.remove(nums[left]);
                    currsum -= nums[left];
                    left++;
                }
            }

        return maxvalue;
    }
    public static void main(String[] args) {
        int[] dataset = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println("Max Sum: " + findMaxSubarraySum(dataset, k)); // Expected: 15 (from sub-array [5, 4, 2])
    }
}
