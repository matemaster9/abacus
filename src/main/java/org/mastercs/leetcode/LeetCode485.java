package org.mastercs.leetcode;

/**
 * Author: matemaster
 * Create: 2023-04-10 19:30
 */
public class LeetCode485 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int totalDuration = 0;
        int n = timeSeries.length;
        for (int i = 0; i < n - 1; i++) {
            // calculate the duration of current attack
            int attackDuration = Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
            // add the duration of current attack to the total duration
            totalDuration += attackDuration;
        }
        // add the duration of the last attack
        totalDuration += duration;
        return totalDuration;
    }

    public static int findPoisonedDuration2(int[] timeSeries, int duration) {
        int totalDuration = 0;
        int expired = 0;
        for (int timeSery : timeSeries) {
            if (timeSery >= expired) {
                totalDuration += duration;
            } else {
                totalDuration += timeSery + duration - expired;
            }
            expired = timeSery + duration;
        }
        return totalDuration;
    }

    public static void main(String[] args) {
        int[] timeSeries = {1, 4, 7, 9};
        int duration = 3;
        int expectedOutput = 10;
        int actualOutput = findPoisonedDuration(timeSeries, duration);
        int actualOutput2 = findPoisonedDuration2(timeSeries, duration);
        System.out.println(actualOutput);
        System.out.println(actualOutput2);
    }
}
