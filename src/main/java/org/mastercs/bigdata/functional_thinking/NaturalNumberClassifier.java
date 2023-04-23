package org.mastercs.bigdata.functional_thinking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NaturalNumberClassifier {

    private final int naturalNumber;

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public NaturalNumberClassifier(int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }

    private boolean isFactor(int potential) {
        return naturalNumber % potential == 0;
    }

    private Set<Integer> getFactors() {
        HashSet<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(naturalNumber);
        for (int i = 2; i < naturalNumber; i++) {
            if (isFactor(i)) factors.add(i);
        }
        return factors;
    }

    public int aliquotSum() {
        if (cache.get(naturalNumber) == null) {
            int sum = 0;
            for (Integer factor : getFactors()) {
                sum += factor;
            }
            cache.put(naturalNumber, sum - naturalNumber);
        }
        return cache.get(naturalNumber);
    }

    public boolean isPerfect() {
        return aliquotSum() == naturalNumber;
    }

    public boolean isAbundant() {
        return aliquotSum() > naturalNumber;
    }

    public boolean isDeficient() {
        return aliquotSum() < naturalNumber;
    }
}