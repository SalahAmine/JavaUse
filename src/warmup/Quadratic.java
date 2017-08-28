package warmup;

import java.util.HashSet;
import java.util.Set;

public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) {
        
        // calculate discriminant 
        // calculate sol 1 and 2 
        Set<Integer>  set =  new HashSet<Integer>() ;
        double disc= computeDiscriminant(a,b,c);
        
        double res1= (-1*b + disc)/(2.0*a) ;
        double res2= (-1*b - disc)/(2.0*a) ;
        
         if ( isInteger(res1) ) 
                set.add((int) res1);
         if ( isInteger(res2) ) 
             set.add((int) res2);
    
         if ( set.isEmpty() )
           throw new RuntimeException(" pas de solutions entière pour cette équation");
       
       return set ;

    }

    
    private static boolean isInteger(double d) {
        return (int) d == d ;
        
    }
    private static double computeDiscriminant(int a, int b, int c){
        
      // caster a et c a une long car si a et c sont <= 2^31 ,  peut ne pas l'etre 4*a*c
      // le calcul sera faussé sans que java leve d'alerte
        return   Math.sqrt(Math.pow(b, 2)- 4*(long)a*(long)c) ;
      
    }
    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = Quadratic.roots(1, -4, 3);
        System.out.println(result);
        
        
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
