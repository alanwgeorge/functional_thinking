package nealford.ft.numberclassification;

// BEGIN functional_number_classifier
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumberClassifier {

    private static boolean isFactor(final int candidate, final int number) {   //<1>
        return number % candidate == 0;                                    
    }                                                                      
                                                                           
    private static Set<Integer> factors(final int number) {                    //<2>
        Set<Integer> factors = new HashSet<>();                            
        factors.add(1);                                                    
        factors.add(number);                                               
        for (int i = 2; i < number; i++)                                   
            if (isFactor(i, number))                                       
                factors.add(i);                                            
        return factors;                                                    
    }                                                                      
                                                                           
    private static int aliquotSum(final Collection<Integer> factors) {
        int sum = 0;
        int targetNumber = Collections.max(factors);
        for (int n : factors) {                                               //<3>
            sum += n;
        }
        return sum - targetNumber;
    }
                                                                           
    private static boolean isPerfect(final int number) {
        return aliquotSum(factors(number)) == number;
    }                                                                      
                                                                              //<4>
    private static boolean isAbundant(final int number) {
        return aliquotSum(factors(number)) > number;
    }

    private static boolean isDeficient(final int number) {
        return aliquotSum(factors(number)) < number;
    }

    public static void main(String[] args) {
        int number = 44;

        System.out.printf("isPerfect %d %b\n", number, NumberClassifier.isPerfect(number));
        System.out.printf("isAbundant() %d %b\n", number, NumberClassifier.isAbundant(number));
        System.out.printf("isDeficient() %d %b\n", number, NumberClassifier.isDeficient(number));
    }
}
// END functional_number_classifier
