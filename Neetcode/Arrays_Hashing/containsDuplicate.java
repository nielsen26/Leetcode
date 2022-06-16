package Arrays_Hashing;

import java.util.HashSet;

public class containsDuplicate {
    public static boolean containDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };

        System.out.println(containDuplicate(arr));
    }
}
