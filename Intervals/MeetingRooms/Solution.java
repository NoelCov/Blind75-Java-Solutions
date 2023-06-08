
/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

import java.util.Collections;;

// Question link: https://www.lintcode.com/problem/920/

// NOTE: Time can be improved by sorting the list so that we can do it in one run checking i and i + 1. 
// This new solution would have a time complexity of O(n log n)

// Time Complexity O(n ^ 2) 
// Space Complexity O(1)
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if ((intervals.get(j).start >= intervals.get(i).start
                        && intervals.get(j).end <= intervals.get(i).end)) {
                    return false;
                }
            }
        }
        return true;
    }
}
