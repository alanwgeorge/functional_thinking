package nealford.ft.numberclassification;

// BEGIN imp_classifier
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImpNumberClassifierSimple {
    private int _number;                          //<1>
    private Map<Integer, Integer> _cache;         //<2>

    private ImpNumberClassifierSimple(int targetNumber) {
      _number = targetNumber;
      _cache = new HashMap<>();
    }

    private boolean isFactor(int potential) {
      return _number % potential == 0;
    }

    private Set<Integer> getFactors() {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(_number);
        for (int i = 2; i < _number; i++)
            if (isFactor(i))
                factors.add(i);
        return factors;
    }

    private int aliquotSum() {                     // <3>
        if (_cache.get(_number) == null) {
            int sum = 0;
            for (int i : getFactors())
                sum += i;
            _cache.put(_number, sum - _number);
        }
        return _cache.get(_number);
    }

    private boolean isPerfect() {
        return aliquotSum() == _number;
    }

    private boolean isAbundant() {
        return aliquotSum() > _number;
    }

    private boolean isDeficient() {
        return aliquotSum() < _number;
    }

    public static void main(String[] args) {
        int number = 44;

        ImpNumberClassifierSimple impNumberClassifierSimple = new ImpNumberClassifierSimple(number);
        System.out.printf("isPerfect %d %b\n", number, impNumberClassifierSimple.isPerfect());
        System.out.printf("isAbundant() %d %b\n", number, impNumberClassifierSimple.isAbundant());
        System.out.printf("isDeficient() %d %b\n", number, impNumberClassifierSimple.isDeficient());
    }
}
// END imp_classifier
