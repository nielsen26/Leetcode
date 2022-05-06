import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int second_num = target - nums[i];

            if (myMap.get(second_num) != null) {
                int[] arr = { myMap.get(second_num), i };
                return arr;
            }

            myMap.put(cur, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        System.out.println(twoSum(nums, 9).toString());
    }
}
