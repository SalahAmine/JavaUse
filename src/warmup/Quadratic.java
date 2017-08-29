package warmup;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) {
        
        assert !(a ==0 && b==0 && c==0 );
        
        Set<Integer>  set =  new HashSet<Integer>() ;
        
        if (a==0) {
            double res= (-1.0*c)/b;
            if (isInteger(res)) {
                set.add((int) res);
            }
        }
        else {
            double disc= computeDiscriminant(a,b,c);
            if ( disc ==0){
                double res= (-1.0*b)/(2*a);
                if (isInteger(res)) 
                    set.add((int) res);   
            }
            else {
                double res1= (-1.0*b + Math.sqrt(disc))/(2*a) ;
                double res2= (-1.0*b - Math.sqrt(disc))/(2*a) ;
                if (isInteger(res1))
                    set.add((int) res1);
                if (isInteger(res2))
                    set.add((int) res2);
                }
        }
        
        set.forEach(x ->{
            assert   Math.abs(a*x*x + b*x +c)<0.01 ; } );
        return set;
        
    }

    
    private static boolean isInteger(double d) {
        return ((int) d - d ) ==0 ;
        
    }
    private static double computeDiscriminant(int a, int b, int c){
        
      // caster a et c a une long car si a et c sont <= 2^31 ,  peut ne pas l'etre 4*a*c
      // le calcul sera faussé sans que java leve d'alerte
        return   Math.pow(b, 2)- 4*(long)a*(long)c ;
      
    }
    /**
     * Main function of program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("For the equation x^2 - 4x + 3 = 0, the possible solutions are:");
        Set<Integer> result = Quadratic.roots(0, -9, 9);
        System.out.println(result);
        

        
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
