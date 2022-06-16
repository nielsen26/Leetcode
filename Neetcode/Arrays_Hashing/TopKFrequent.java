package Arrays_Hashing;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();

        for (int num : nums) {
            if (mem.containsKey(num)) {
                mem.put(num, mem.get(num) + 1);
            } else {
                mem.put(num, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> mem.get(b) - mem.get(a));

        for (int key : mem.keySet()) {
            pq.add(key);
        }

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = pq.remove();
        }

        return arr;
    }
}
