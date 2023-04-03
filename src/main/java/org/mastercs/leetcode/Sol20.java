package org.mastercs.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Sol20 {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> lStack = new ArrayDeque<>();
        Deque<Character> rStack = new ArrayDeque<>();
        for (char elem : chars) {
            if (elem == '{' || elem == '[' || elem == '(') {
                lStack.push(elem);
            }
            if (elem == '}' || elem == ']' || elem == ')') {
                rStack.push(elem);
            }
        }
        if (lStack.size() != rStack.size()) {
            return false;
        }
        for (int i = 0; i < lStack.size(); i++) {
            char l = lStack.pop();
            char r = rStack.pop();
            if (l == '{') {
                if (r == ')' || r == ']') {
                    return false;
                }
            }
            if (l == '[') {
                if (r == '}' || r == ')') {
                    return false;
                }
            }
            if (l == '(') {
                if (r == '}' || r == ']') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid2(String s) {
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char elem : chars) {
            if (map.containsKey(elem)) {
                if (stack.isEmpty() || stack.peek() != map.get(elem)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(elem);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Sol20().isValid("([)]"));
        System.out.println(new Sol20().isValid2("()[]"));
    }
}
