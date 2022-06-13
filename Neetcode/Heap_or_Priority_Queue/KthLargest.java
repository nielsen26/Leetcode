package Heap_or_Priority_Queue;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;

        for (int num : nums)
            pq.offer(num);

        while (k < pq.size())
            pq.poll();
    }

    public int add(int val) {
        pq.offer(val);

        if (pq.size() > size)
            pq.poll();

        return pq.peek();
    }
}
