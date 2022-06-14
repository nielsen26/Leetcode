package Two_Pointers;

public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target)
                break;

            if (numbers[start] + numbers[end] < target)
                start++;
            else
                end--;
        }

        return new int[] { start + 1, end + 1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4 };
        System.out.println(twoSum(arr, 6));
    }
}