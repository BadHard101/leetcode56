package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution2 {
    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        int[] current = intervals[0];
        result.add(current);

        for (int[] interval: intervals) {
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                result.add(interval);
                current = interval;
            }

        }

        return result.toArray(new int[result.size()][]);

    }
}