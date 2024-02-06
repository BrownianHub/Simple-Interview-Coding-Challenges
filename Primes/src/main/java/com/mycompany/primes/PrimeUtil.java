package com.mycompany.primes;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Dan Brown
 */
public class PrimeUtil {
    public static final String DEFAULT_RETURN_STRING_VALUE = "MARRY";
    
    public PrimeUtil() { }
    
    // removes all primeFrequency chars from a string
    public String removePrimeFrequencyChars(String s) {
        String resultString = "";
        Map<Character, Integer> charFrequencyMap = this.getCharFrequencyMap(s);
        Map<Character,Boolean> charPrimeMap = this.getCharPrimeFrequencyMap(charFrequencyMap);
        
        // loop through string, and build up the characters that are NOT found in the charPrimeMap into a new string
        for(int i = 0; i < s.length(); i ++) {
             char c = s.charAt(i); 
             // only add to string if we do NOT see it in the map (is not of a prime frequency)
             if(charPrimeMap.get(c) == null) {
                 resultString += c;
             }
        }
        // return default string if empty string after "removals"
        if (resultString.isEmpty()) {
            resultString = PrimeUtil.DEFAULT_RETURN_STRING_VALUE;
        }
        return resultString;
    }
    
    
    // transform map of frequency into one that records if that frequence is prime (thus a map of char to boolean)
    public Map<Character,Boolean> getCharPrimeFrequencyMap(Map<Character, Integer> charFrequencyMap) {
        Map<Character,Boolean> charPrimeMap = new HashMap<>();
        
        // build up the charPrimeMap, which is just a map of which characters in the string occur with a frequency that is a prime number
        for (char c : charFrequencyMap.keySet()) {
            Integer frequency = charFrequencyMap.get(c);
            if (this.isPrime(frequency)) {          // check if frequency is a prime number; only if yes, then add to map
                charPrimeMap.put(c, true);
            }
        }
        return charPrimeMap;
    }
    
    
    // get frequency of chars in string as a map
    public Map<Character, Integer> getCharFrequencyMap(String s) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);       // get character at index i
            // if does not exist in map, then add it, else increment its frequency
            if (charFrequencyMap.get(c ) == null) {
                charFrequencyMap.put(c, 1);
            }
            else {
                charFrequencyMap.put(c, charFrequencyMap.get(c ) + 1 );
            }
        }
        return charFrequencyMap;
    }
    
    
    // helper method for determining if integer is prime
    public Boolean isPrime(Integer n) {
        if (n < 2) {        // edge cases
            return false;
        }
        // otherwise, we only have to go up to n/2, since otherwise, it would have been already divisible by 2
        for(int i = 2; i <= n /2; i++) {
            if (n % i == 0) {       // if remainder is 0, then it perfectly divides, hence not prime, return false
                return false;
            }
        }
        return true;        // otherwise, we went through all numbers up to n/2, so return true
    }
    
  
    
}
