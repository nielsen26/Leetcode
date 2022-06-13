package Heap_or_Priority_Queue;

import java.util.PriorityQueue;

public class Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int num : stones)
            pq.offer(num);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y)
                pq.offer(y - x);
        }

        if (pq.size() == 0)
            return 0;

        return pq.poll();
    }
}
