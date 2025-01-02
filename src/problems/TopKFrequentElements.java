package problems;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> kFrequent = new HashMap<>();
//        for(int num : nums) {
//            kFrequent.put(num, kFrequent.getOrDefault(num, 0) + 1);
//        }
//
//        List<Integer> buckets = new ArrayList<>();
//        for(int num : kFrequent.keySet()) {
//            buckets.add(num);
//        }
//
//        buckets.sort((a, b) -> kFrequent.get(b) - kFrequent.get(a));
//
//        int[] result = new int[k];
//        for(int i = 0; i < k; i++) {
//            result[i] = buckets.get(i);
//        }
//
//        return result;
        HashMap<Integer, Integer> kFrequent = new HashMap<>();
        for(int num : nums) {
            kFrequent.put(num, kFrequent.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        for(Map.Entry<Integer, Integer> entry : kFrequent.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
   }
}
