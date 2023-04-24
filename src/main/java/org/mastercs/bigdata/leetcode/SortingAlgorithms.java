package org.mastercs.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Author: matemaster
 * Create: 2023-04-10 14:38
 */
public class SortingAlgorithms {

    public static void quickSort(int[] arr, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int r = stack.pop();
            int l = stack.pop();
            if (l < r) {
                int pivot = partition(arr, l, r);
                stack.push(l);
                stack.push(pivot - 1);
                stack.push(pivot + 1);
                stack.push(r);
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // Output: [1, 2, 5, 5, 6, 9]
    }
}
