package nealford.ft.numberclassification;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;

// BEGIN number_classifier_functional_optimized
public class NumberClassifierOptimized {
                                                                           
    private static boolean isFactor(final int candidate, final int number) {
        return number % candidate == 0;                                    
    }                                                                      
                                                                           
    private static Set<Integer> factors(final int number) {
        Set<Integer> factors = new HashSet<>();                            
        factors.add(1);                                                    
        factors.add(number);                                               
        for (int i = 2; i <= sqrt(number); i++)
            if (isFactor(i, number)) {                                     
                factors.add(i);                                            
                factors.add(number / i);                                   
            }                                                              
        return factors;                                                    
    }                                                                      
                                                                           
    private static int sum(final Collection<Integer> numbers) {
        int sum = 0;                                                       
        for (int n : numbers)                                              
            sum += n;                                                      
        return sum;                                                        
    }                                                                      
                                                                           
    private static boolean isPerfect(final int number) {
        return sum(factors(number)) - number == number;                    
    }

    private static boolean isAbundant(final int number) {
        return sum(factors(number)) - number > number;
    }

    private static boolean isDeficient(final int number) {
        return sum(factors(number)) - number < number;
    }

    public static void main(String[] args) {
        int number = 44;

        System.out.printf("isPerfect %d %b\n", number, NumberClassifierOptimized.isPerfect(number));
        System.out.printf("isAbundant() %d %b\n", number, NumberClassifierOptimized.isAbundant(number));
        System.out.printf("isDeficient() %d %b\n", number, NumberClassifierOptimized.isDeficient(number));
    }
}
// END number_classifier_functional_optimized