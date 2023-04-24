package org.mastercs.bigdata.leetcode;

import java.util.Set;
import java.util.stream.Collectors;

public class Sol3 {

    public int lengthOfLongestSubstring(String s) {
        return 0;
    }

    private boolean hasDuplicateCharacter(String arg) {
        Set<Character> collect = arg.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        return collect.size() == arg.length();
    }

    public static void main(String[] args) {
        System.out.println(new Sol3().hasDuplicateCharacter("scala"));
        System.out.println(new Sol3().hasDuplicateCharacter("openjdk"));

        String str = "JavaExamples";
        int count;
        char[] ch = str.toCharArray();
        System.out.println("Duplicate characters in a given string: ");
        for (int i = 0; i < ch.length; i++) {
            count = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j] && ch[i] != ' ') {
                    count++;
                    ch[j] = '0';
                }
            }
            if (count > 1 && ch[i] != '0') {
                System.out.println(ch[i]);
            }
        }
    }
}
