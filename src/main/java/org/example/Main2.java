package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main2 {
    public static int[][] mergeIntervals(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0])); //
        int[] temp = intervals[0];
        for (int[] interval : intervals) {
            if (temp[1] < interval[0]) {
                ans.add(temp);
                temp = interval;
            }
            else {
                //temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        ans.add(temp);
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1,3},{2,8},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{2,6},{1,3},{8,10},{15,18}})));
    }
}