package org.example;

import java.util.*;

public class Main {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        LinkedHashMap<Integer, Integer> order = new LinkedHashMap<>();

        order.put(intervals[0][0], intervals[0][1]);
        int lastKey = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > order.get(lastKey)) {
                if (order.get(lastKey) >= intervals[i][0]) {
                    order.put(lastKey, intervals[i][1]);
                } else {
                    order.put(intervals[i][0], intervals[i][1]);
                    lastKey = intervals[i][0];
                }
            }
        }

        int[][] ans = new int[order.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry: order.entrySet()) {
            ans[i][0] = entry.getKey();
            ans[i][1] = entry.getValue();
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(merge(new int[][]{{1,3},{2,4},{5,8},{8,14},{13,18}})));
        //System.out.println(Arrays.deepToString(merge(new int[][]{{1,4},{5,6}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}})));
    }
}