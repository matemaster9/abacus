package org.mastercs.bigdata.functional_thinking;


import fj.data.List;

import static fj.data.List.range;

public class FJNaturalNumberClassifier {
    public List<Integer> factorsOf(final int number) {
        return range(1, number + 1).filter(i -> number % i == 0);
    }

    public int aliquotSum(List<Integer> factors) {
        return factors.foldLeft(fj.function.Integers.add, 0) - factors.last();
    }

    public boolean isPerfect(int number) {
        return aliquotSum(factorsOf(number)) == number;
    }

    public boolean isAbundant(int number) {
        return aliquotSum(factorsOf(number)) > number;
    }

    public boolean isDeficient(int number) {
        return aliquotSum(factorsOf(number)) < number;
    }
}
