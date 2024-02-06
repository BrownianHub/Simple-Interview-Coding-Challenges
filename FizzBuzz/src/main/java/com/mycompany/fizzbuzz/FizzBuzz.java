package com.mycompany.fizzbuzz;

import java.util.HashMap;

/**
 *
 * @author Dan Brown
 */
public class FizzBuzz {
    
    public static final int DEFAULT_FIZZ_MODULUS = 3;       // default modulus for fizz
    public static final int DEFAULT_BUZZ_MODULUS = 5;       // default modulus for buzz
    
    // default strings for fizz, buzz, fizzbuzz...
    public static final String DEFAULT_FIZZ_STRING = "Fizz";
    public static final String DEFAULT_BUZZ_STRING = "Buzz";
    public static final String DEFAULT_FIZZBUZZ_STRING = "FizzBuzz";
    
    public HashMap<Integer, String> fizzBuzzMap;    // custom map for fizz buzz strings and modulus
    
    
    public FizzBuzz() {
        fizzBuzzMap = new HashMap<>();
        fizzBuzzMap.put(DEFAULT_FIZZ_MODULUS, DEFAULT_FIZZ_STRING);
        fizzBuzzMap.put(DEFAULT_BUZZ_MODULUS, DEFAULT_BUZZ_STRING);
        // add more if we wish
    }
    
    // Or we can even define a new FizzBuzz constructor with custom map, like so:
    public FizzBuzz(HashMap<Integer, String> fizzBuzzCustomMap) {
        this.fizzBuzzMap = fizzBuzzCustomMap;
    }

    
    // custom fizzBuzz dynamic method; you supply a hashmap of ints and strings, and it will produce the fizzbuzz string depending on the 
    //  number's factors
    public String getDynamicFizzBuzz(int n, HashMap<Integer, String> fizzBuzzCustomMap) {
        String fizzBuzzStr = "";
        for(int modulusKey : fizzBuzzCustomMap.keySet()) {
            if (n % modulusKey == 0) {
                fizzBuzzStr += fizzBuzzCustomMap.get(modulusKey);
            }
        }
        return fizzBuzzStr;
    }
    
    // default implementation of dynamic fizzbuzz method, where we supply the default hashmap of this class
    public String getDynamicFizzBuzz(int n) {
        return getDynamicFizzBuzz(n, this.fizzBuzzMap);
    }
    
    
    // the original and simple way to implement the fizzbuzz method (not dynamic)
    public String getFizzBuzz(int n) {
        String fizzBuzzStr = "";
        if( (n % DEFAULT_BUZZ_MODULUS == 0) && (n % DEFAULT_FIZZ_MODULUS == 0) ) {
            fizzBuzzStr = DEFAULT_FIZZBUZZ_STRING;
        }
        else if(n %DEFAULT_BUZZ_MODULUS == 0) {
            fizzBuzzStr = DEFAULT_BUZZ_STRING;
        }
        else if(n % DEFAULT_FIZZ_MODULUS == 0) {
            fizzBuzzStr = DEFAULT_FIZZ_STRING;
        }
        return fizzBuzzStr;
    }
    
    
    
    
    public static void main(String[] args) {
        
        FizzBuzz fizzBuzz = new FizzBuzz();
        
        // These should be the same
        System.out.println(fizzBuzz.getFizzBuzz(15));
        System.out.println(fizzBuzz.getDynamicFizzBuzz(15));

      
        // But, now let's add a custom fizz buzz map instead
        HashMap<Integer, String> fizzBuzzCustomMap = new HashMap<>();
        fizzBuzzCustomMap.put(3, "Fizzy");
        fizzBuzzCustomMap.put(5, "Buzzy");
        fizzBuzzCustomMap.put(7, "Suzzy");
        
        FizzBuzz fizzBuzzNew = new FizzBuzz(fizzBuzzCustomMap);     // create new fizz buzz with the new custom fizzbuzz map
        // see what happens now --> should print out:  FizzyBuzzySuzzy
        System.out.println(fizzBuzzNew.getDynamicFizzBuzz(105));         // 105 --> 3*5*7 
        
    }
    
    
}
