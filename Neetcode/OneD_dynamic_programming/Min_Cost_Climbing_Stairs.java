package OneD_dynamic_programming;

public class Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost) {
        int last = cost[cost.length - 1];
        int secondlast = cost[cost.length - 2];

        for (int i = cost.length - 3; i >= 0; i--) {
            int min = last < secondlast ? last : secondlast;
            cost[i] += min;
            last = secondlast;
            secondlast = cost[i];
        }

        return cost[0] < cost[1] ? cost[0] : cost[1];
    }
}
