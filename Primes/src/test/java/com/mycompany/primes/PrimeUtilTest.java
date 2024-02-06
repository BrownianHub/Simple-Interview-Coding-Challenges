
package com.mycompany.primes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Dan Brown
 */
public class PrimeUtilTest {
    
    public PrimeUtilTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    public String parameterObjectsToString(Object[] object) {
        return Arrays.toString(object).replace("[" , "(").replace("]" , ")");
    }
    

    private static Stream<Arguments> isPrimeMethodSource() {
       return Stream.of(
           Arguments.of(1, false),
           Arguments.of(2, true),
           Arguments.of(3, true),
           Arguments.of(4, false),
           Arguments.of(5, true),
           Arguments.of(6, false),
           Arguments.of(7, true),
           Arguments.of(8, false),
           Arguments.of(13, true),
           Arguments.of(19, true),
           Arguments.of(30, false),
           Arguments.of(45, false),
           Arguments.of(7919, true)
             
       );
    }
    /**
     * Test of isPrime method, of class PrimeUtil.
     */
    @ParameterizedTest
    @MethodSource("isPrimeMethodSource")
    public void testIsPrime(Integer input, Boolean expected) {
        System.out.println("isPrime" + parameterObjectsToString(new Object[] {input, expected} ));
        
        PrimeUtil instance = new PrimeUtil();
        Boolean result = instance.isPrime(input);
        assertEquals(expected, result);
    }
    


    
    private static Stream<Arguments> removePrimeFrequencyCharsMethodSource() {
       return Stream.of(
           Arguments.of("aaabbb", PrimeUtil.DEFAULT_RETURN_STRING_VALUE),
           Arguments.of("aaaabbc", "aaaac"),
           Arguments.of("aaac", "c"),
           Arguments.of("aaaaaaaaaaaaabbc", "c"),
           Arguments.of("aaaaaabaaaaaabac", "c"),
           Arguments.of("a", "a"),
           Arguments.of("cc", PrimeUtil.DEFAULT_RETURN_STRING_VALUE),
           Arguments.of("", PrimeUtil.DEFAULT_RETURN_STRING_VALUE)
       );
    }
    /**
     * Test of removePrimeFrequencyChars method, of class PrimeUtil.
     */
    @ParameterizedTest
    @MethodSource("removePrimeFrequencyCharsMethodSource")
    public void testRemovePrimeFrequencyChars(String input, String expected) {
        System.out.println("removePrimeFrequencyChars" + parameterObjectsToString(new Object[] {input, expected} ));

        PrimeUtil instance = new PrimeUtil();
        String result = instance.removePrimeFrequencyChars(input);
        assertEquals(expected, result);

    }

    
    
    private static Stream<Arguments> getCharPrimeFrequencyMapMethodSource() {
       Map<Character, Boolean> charFrequencyMap = new HashMap<>();
       charFrequencyMap.put('a',true);
       charFrequencyMap.put('b',true);

       Map<Character, Boolean> charFrequencyMap2 = new HashMap<>();
       charFrequencyMap2.put('a',true);

       return Stream.of(
           Arguments.of("aabb",  charFrequencyMap),
           Arguments.of("aaabbbbc", charFrequencyMap2)

       );
    }
    /**
     * Test of getCharPrimeFrequencyMap method, of class PrimeUtil.
     */
    @ParameterizedTest
    @MethodSource("getCharPrimeFrequencyMapMethodSource")
    public void testGetCharPrimeFrequencyMap(String input, Map<Character, Boolean> expected) {
        System.out.println("getCharPrimeFrequencyMap" + parameterObjectsToString(new Object[] {input, expected} ));
        
        PrimeUtil instance = new PrimeUtil();
        Map<Character, Integer> charFrequencyMap =  instance.getCharFrequencyMap(input);
        Map<Character, Boolean> result = instance.getCharPrimeFrequencyMap(charFrequencyMap);
        assertEquals(expected, result);

    }

    
    
    private static Stream<Arguments> getCharFrequencyMapMethodSource() {
       Map<Character, Integer> charFrequencyMap = new HashMap<>();
       charFrequencyMap.put('a',2);
       charFrequencyMap.put('b',2);

       Map<Character, Integer> charFrequencyMap2 = new HashMap<>();
       charFrequencyMap2.put('a',3);
       charFrequencyMap2.put('b',4);
       charFrequencyMap2.put('c',1);

       return Stream.of(
           Arguments.of("aabb",  charFrequencyMap),
           Arguments.of("aaabbbbc", charFrequencyMap2)

       );
    }
    /**
     * Test of getCharFrequencyMap method, of class PrimeUtil.
     */
    @ParameterizedTest
    @MethodSource("getCharFrequencyMapMethodSource")
    public void testGetCharFrequencyMap(String input, Map<Character, Integer> expected) {
        System.out.println("getCharFrequencyMap" + parameterObjectsToString(new Object[] {input, expected} ));
        
        PrimeUtil instance = new PrimeUtil();
        Map<Character, Integer> result = instance.getCharFrequencyMap(input);
        assertEquals(expected, result);
    }

 
   
}
