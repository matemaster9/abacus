package org.mastercs.functional_programming;

import java.util.function.Supplier;

public class LazyEvaluationExample {

    public static void main(String[] args) {
        Supplier<Integer> x = () -> {
            System.out.println("Evaluating x");
            return 1 + 2;
        };

        Supplier<Integer> y = () -> {
            System.out.println("Evaluating y");
            return 3 + 4;
        };

        System.out.println("Before using x and y");
        System.out.println("x: " + x.get());
        System.out.println("y: " + y.get());
        System.out.println("After using x and y");
    }
}
