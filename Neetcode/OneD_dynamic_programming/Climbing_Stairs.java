package OneD_dynamic_programming;

public class Climbing_Stairs {
    private int[] arr;
    private int top;

    public int climbStairs(int n) {
        arr = new int[n];
        top = n;
        return climb(0);
    }

    private int climb(int cur) {
        if (cur == top)
            return 1;
        else if (cur < top) {
            if (arr[cur] == 0) {
                arr[cur] = climb(cur + 1) + climb(cur + 2);
            }
            return arr[cur];
        }
        return 0;
    }
}
