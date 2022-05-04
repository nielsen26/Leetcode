import java.util.PriorityQueue;

class LongestSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int num : nums) {
            if (!pq.contains(num))
                pq.add(num);
        }

        int prev = pq.poll();
        int longest = 1;
        int cur = 1;

        while (pq.size() > 0) {
            int num = pq.poll();

            if (num - 1 == prev)
                cur++;
            else
                cur = 0;
            prev = num;

            longest = (longest > cur) ? longest : cur;
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
        System.out.println(longestConsecutive(arr));
    }
}