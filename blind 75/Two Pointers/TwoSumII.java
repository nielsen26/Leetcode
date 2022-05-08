import java.util.HashMap;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>(); // Key is number looked for, value is the index

        for (int i = 0; i < numbers.length; i++) {
            int num1 = numbers[i];
            int num2 = target - num1;

            if (mem.containsKey(num2)) {
                ret[0] = mem.get(num2) + 1;
                ret[1] = i + 1;
                return ret;
            }

            mem.put(num1, i);
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4 };
        System.out.println(twoSum(arr, 6));
    }
}