package org.mastercs.bigdata.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Offer6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode n = head;
        while (n != null) {
            stack.push(n.val);
            n = n.next;
        }
        return stack.stream().mapToInt(elem -> elem).toArray();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(Arrays.toString(new Offer6().reversePrint(listNode)));
    }
}
