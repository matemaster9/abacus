package org.mastercs.bigdata.leetcode;

import java.util.Arrays;

/**
 * @author HUAWEI
 * @date 2023/4/5 6:25
 */
public class Sol2427 {

    public int commonFactors(int a, int b) {
        int small = Math.min(a, b);
        int count = 0;
        for (int i = 1; i <= small; i++) {
            if ((a %i == 0) && (b % i == 0) ){
                count++;
            }
        }
        return count;
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearch(arr, key, mid + 1, high);
        } else {
            return binarySearch(arr, key, low, mid - 1);
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 7, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
