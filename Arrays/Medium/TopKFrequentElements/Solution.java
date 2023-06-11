package Arrays.Medium.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Question link: https://leetcode.com/problems/top-k-frequent-elements/

public class Solution {
    // Time Complexity O(n * m) m = the longest list that bucket has.
    // Space Complexity O(n)
    public int[] topKFrequent(int[] nums, int k) {
        // Get the frequency of each distinct number in the array nums
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Put frequencies in an array of ArrayLists that will save which nums have what
        // frequencies using the index (so we don't have to sort)
        // if 1 appears 3 times it will be in bucket[3] etc.
        ArrayList<Integer>[] bucket = new ArrayList[nums.length];
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            int freq = mapEntry.getValue();
            if (bucket[freq - 1] == null) {
                bucket[freq - 1] = new ArrayList<Integer>();
            }
            ArrayList list = bucket[freq - 1];
            list.add(mapEntry.getKey());
        }

        int[] res = new int[k];
        int curr = 0;

        // Iterate backwards to get last result.
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (curr >= k) {
                break;
            }

            if (bucket[i] == null) {
                continue;
            } else {
                ArrayList list = bucket[i];
                for (int j = 0; j < list.size(); j++) {
                    if (curr >= k) {
                        break;
                    }
                    res[curr] = (int) list.get(j);
                    curr++;
                }
            }
        }
        return res;
    }
}
