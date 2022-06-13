import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new LinkedList<>();

        Arrays.sort(nums);

        HashSet<List<Integer>> list = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int pnt2 = i + 1;
            int pnt3 = nums.length - 1;

            int tar = 0 - nums[i];
            while (pnt2 < pnt3) {
                if (pnt2 > i + 2 && nums[pnt2] == nums[pnt2 - 1]) {
                    pnt2++;
                    continue;
                }
                if (pnt3 < nums.length - 2 && nums[pnt3] == nums[pnt3 + 1]) {
                    pnt3--;
                    continue;
                }
                if (nums[pnt2] + nums[pnt3] == tar) {
                    list.add(Arrays.asList(new Integer[] { nums[i], nums[pnt2], nums[pnt3] }));
                }
                if (nums[pnt2] + nums[pnt3] < tar)
                    pnt2++;
                else
                    pnt3--;
            }
        }

        return new LinkedList<>(list);
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { 0, 0, 0, 0 }).toString());
    }
}