package Greedy;

/**
 * Maximum_Subarray
 */
public class Maximum_Subarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];

        int curSum = 0;

        for (int num : nums) {
            curSum += num;
            sum = sum > curSum ? sum : curSum;
            if (curSum < 0)
                curSum = 0;
        }

        return sum;
    }
}