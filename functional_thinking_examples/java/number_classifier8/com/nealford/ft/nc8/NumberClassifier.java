package com.nealford.ft.nc8;

// BEGIN number_classifier_java8
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class NumberClassifier {

    // BEGIN java8_filter
    private static IntStream factorsOf(int number) {
        return range(1, number + 1)
                .filter(potential -> number % potential == 0);
    }
    // END java8_filter

    private static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    private static boolean isPerfect(int number) {
        return aliquotSum(number) == number;
    }

    private static boolean isAbundant(int number) {
        return aliquotSum(number)> number;
    }

    private static boolean isDeficient(int number) {
        return aliquotSum(number) < number;
    }

    public static List fastFactorsOf(int number) {
        List<Integer> factors = range(1, (int) (sqrt(number) + 1))
                .filter(potential -> number % potential == 0)
                .boxed()
                .collect(toList());
        List factorsAboveSqrt = factors
                .stream()
                .map(e -> number / e).collect(toList());
        factors.addAll(factorsAboveSqrt);
        return factors.stream().distinct().collect(toList());
    }


    public static void main(String[] args) {
        IntStream numbers = range(1, 10000);

        numbers.forEach(i -> {
            if (NumberClassifier.isPerfect(i)) System.out.printf("%d isPerfect\n", i);
//            if (NumberClassifier.isAbundant(i)) System.out.printf("%d isAbundant\n", i);
//            if (NumberClassifier.isDeficient(i)) System.out.printf("%d isDeficient\n", i);
        });
    }
}
// END number_classifier_java8

    // BEGIN java8_filter_fast
    //    public static List fastFactorsOf(int number) {
    //        List<Integer> factors = range(1, (int) (sqrt(number) + 1))
    //                .filter(potential -> number % potential == 0)
    //                .boxed()
    //                .collect(toList());
    //        List factorsAboveSqrt = factors
    //                .stream()
    //                .map(e -> number / e).collect(toList());
    //        factors.addAll(factorsAboveSqrt);
    //        return factors.stream().distinct().collect(toList());
    //    }
    // END java8_filter_fast




