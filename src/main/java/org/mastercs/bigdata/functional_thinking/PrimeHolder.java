package org.mastercs.bigdata.functional_thinking;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Math.sqrt;

public class PrimeHolder implements Iterable<Integer> {
    public static boolean isFactor(final int potential, final int number) {
        return number % potential == 0;
    }

    public static Set<Integer> getFactors(final int number) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i < sqrt(number) + 1; i++)
            if (isFactor(i, number)) {
                factors.add(i);
                factors.add(number / i);
            }
        return factors;
    }

    public static int sumFactors(final int number) {
        int sum = 0;
        for (int i : getFactors(number))
            sum += i;
        return sum;
    }

    public static boolean isPrime(final int number) {
        return sumFactors(number) == number + 1;
    }

    public static Integer nextPrimeFrom(final int lastPrime) {
        int candidate = lastPrime + 1;
        while (!isPrime(candidate)) candidate++;
        return candidate;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new PrimeIterator();
    }

    private static class PrimeIterator implements Iterator<Integer> {

        private int lastPrime = 1;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return lastPrime = PrimeHolder.nextPrimeFrom(lastPrime);
        }

        @Override
        public void remove() {
            throw new RuntimeException("颠覆宇宙真理的异常！");
        }
    }
}