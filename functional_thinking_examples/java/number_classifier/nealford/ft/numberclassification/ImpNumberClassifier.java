package nealford.ft.numberclassification;
// BEGIN number_classifier_imperative_optimized

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.sqrt;

public class ImpNumberClassifier {
    private int _number;                          //<1>
    private Map<Integer, Integer> _cache;         //<2>

    private ImpNumberClassifier(int targetNumber) {
        _number = targetNumber;
        _cache = new HashMap<>();
    }

    private boolean isFactor(int candidate) {
        return _number % candidate == 0;
    }

    private Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i <= sqrt(_number); i++)  //<3>
            if (isFactor(i)) {
                factors.add(i);
                factors.add(_number / i);
            }
        return factors;
    }

    private int aliquotSum() {
        int sum = 0;
        for (int i : getFactors())
            sum += i;
        return sum - _number;
    }

    private int cachedAliquotSum() {              //<4>
        if (_cache.containsKey(_number))
            return _cache.get(_number);
        else {
            int sum = aliquotSum();
            _cache.put(_number, sum);
            return sum;
        }
    }

    private boolean isPerfect() {
        return cachedAliquotSum() == _number;
    }

    private boolean isAbundant() {
        return cachedAliquotSum() > _number;
    }

    private boolean isDeficient() {
        return cachedAliquotSum() < _number;
    }

    public static void main(String[] args) {
        int number = 44;

        ImpNumberClassifier impNumberClassifier = new ImpNumberClassifier(number);
        System.out.printf("isPerfect %d %b\n", number, impNumberClassifier.isPerfect());
        System.out.printf("isAbundant() %d %b\n", number, impNumberClassifier.isAbundant());
        System.out.printf("isDeficient() %d %b\n", number, impNumberClassifier.isDeficient());
    }

}
// END number_classifier_imperative_optimized