package org.mastercs.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer9 {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(100);
        queue.appendTail(200);
        queue.appendTail(300);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

}

class CQueue {

    private final Deque<Integer> input;
    private final Deque<Integer> output;

    public CQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        input.push(value);
    }

    public int deleteHead() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }
}
