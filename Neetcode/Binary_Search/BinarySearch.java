package Binary_Search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target)
                return mid;
            if (target < nums[mid])
                end = mid;
            else {
                if ((start + end) % 2 == 0)
                    start = mid;
                else
                    start = mid + 1;
            }
        }

        if (nums[end] == target)
            return end;

        return -1;
    }
}
