package org.mastercs.bigdata.functional_thinking;

import java.util.stream.IntStream;

public class JavaStreamNaturalNumberClassifier {

    public static int aliquotSumOf(int targetNumber) {
        return IntStream.range(1, targetNumber + 1)
                .filter(potential -> targetNumber % potential == 0)
                .sum();
    }

    public static boolean isPerfect(final int number) {
        return aliquotSumOf(number) == number;
    }

    public static boolean isAbundant(final int number) {
        return aliquotSumOf(number) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquotSumOf(number) < number;
    }
}
