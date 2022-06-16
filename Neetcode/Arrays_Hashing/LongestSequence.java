import java.util.ArrayList;
import java.util.List;

public class LongestSequence {
    public static void binaryInsert(List<Integer> list, int val) {
        if (list.size() == 0) {
            list.add(val);
            return;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int cur = list.get(mid);

            if (val < cur)
                end = mid;
            else {
                if ((start + end) % 2 == 1)
                    start = mid + 1;
                else
                    start = mid;
            }
        }

        if (val < list.get(start))
            list.add(start, val);
        else
            list.add(start + 1, val);
    }

    public static Boolean binarySearch(List<Integer> list, int val) {
        if (list.size() == 0) {
            return false;
        }

        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            int cur = list.get(mid);

            if (val == cur)
                return true;

            if (val < cur)
                end = mid;
            else {
                if ((start + end) % 2 == 1)
                    start = mid + 1;
                else
                    start = mid;
            }
        }

        if (val == list.get(start))
            return true;
        else
            return false;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if (!binarySearch(list, num))
                binaryInsert(list, num);
        }

        int prev = list.get(0);
        int longest = 1;
        int cur = 1;

        for (int i = 1; i < list.size(); i++) {
            int num = list.get(i);

            if (num - 1 == prev) {
                cur++;
                longest = (longest > cur) ? longest : cur;
            } else {
                if (longest > list.size())
                    return longest;
                cur = 1;
            }
            prev = num;
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
        System.out.println(longestConsecutive(arr));
    }
}