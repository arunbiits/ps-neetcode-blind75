package io.arun.cp.blind75.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 * Input: nums=[1,1,1,2,2,3], k=2
 * Output: [1,2]
 *
 * Time: O(n)
 * Space: O(n)
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key: countMap.keySet()) {
            int freq = countMap.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int[] result = new int[k];
        int idx = 0;
        for(int i=bucket.length-1;i>=0 && idx < k;i--) {
            if(bucket[i] != null) {
                for(int n: bucket[i]) {
                    result[idx++] = n;
                    if(idx==k) break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }
}
