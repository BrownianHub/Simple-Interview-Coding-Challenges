
package com.mycompany.listnodes;

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
public class ListNodeUtilTest {
    
    public ListNodeUtilTest() {
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
    

    private static Stream<Arguments> listNodeMethodSource() {
        ListNode original = new ListNode(Arrays.asList(5,4,3, 2, 1));
        ListNode reversed = new ListNode(Arrays.asList(1,2,3, 4, 5));     
        
        ListNode originalNew = new ListNode(Arrays.asList(5,25,15, 10, 0));
        ListNode reversedNew = new ListNode(Arrays.asList(0,10,15, 25, 5));
        
        return Stream.of(
            Arguments.of(original , reversed ),
            Arguments.of(originalNew , reversedNew )
          
             
       );
    }
    /**
     * Test of reverseList method, of class ListNodeUtil.
     * @param input
     * @param expected
     */
    @ParameterizedTest
    @MethodSource("listNodeMethodSource")
    public void testReverseList(ListNode input, ListNode expected) {
        System.out.println("listNodeMethodSource" + parameterObjectsToString(new Object[] {input, expected} ));
        
        ListNodeUtil instance = new ListNodeUtil();
        ListNode result = instance.reverseList(input);
        assertEquals(expected, result);
    }
    
    
    

    private static Stream<Arguments> kFromEndMethodSource() {
        ListNode original = new ListNode(Arrays.asList(5,4,3, 2, 1));            
        ListNode originalNew = new ListNode(Arrays.asList(5,25,15, 10, 0));
        ListNode originalOne = new ListNode(Arrays.asList(5));
        
        return Stream.of(
                Arguments.of(original , 6,  -1),
                Arguments.of(original , 5,  -1),
                Arguments.of(original , -1,  -1),
                Arguments.of(original , 4,  5),
                Arguments.of(original , 3,  4),
                Arguments.of(original , 2 , 3),
                Arguments.of(original , 1 , 2),
                Arguments.of(original , 0 , 1),
                
                Arguments.of(originalNew , 0,0 ),
                Arguments.of(originalNew , 1,  10),
                Arguments.of(originalNew , 2,  15),
                Arguments.of(originalNew , 3,  25),
                Arguments.of(originalNew , 4,  5),
                Arguments.of(originalNew , 5,  -1),
                
                Arguments.of(originalOne , 2,  -1),
                Arguments.of(originalOne , 1,  -1),
                Arguments.of(originalOne , -1,  -1),
                Arguments.of(originalOne , 0,  5)
       );
    }
    /**
     * Test of getKthFromEnd method, of class ListNodeUtil.
     * @param input
     * @param k
     * @param expected
     */
    @ParameterizedTest
    @MethodSource("kFromEndMethodSource")
    public void testGetKthFromEnd(ListNode input, int k, Integer expected) {
        System.out.println("kFromEndMethodSource" + parameterObjectsToString(new Object[] {input, k, expected} ));
        
        ListNodeUtil instance = new ListNodeUtil();
        Integer result = instance.getKthFromEnd(input, k);
        assertEquals(expected, result);
    }
    
    
        /**
     * Test of getKthFromEnd method, of class ListNodeUtil.
     * @param input
     * @param k
     * @param expected
     */
    @ParameterizedTest
    @MethodSource("kFromEndMethodSource")
    public void testGetKthFromEndListConvert(ListNode input, int k, Integer expected) {
        System.out.println("kFromEndMethodSource" + parameterObjectsToString(new Object[] {input, k, expected} ));
        
        ListNodeUtil instance = new ListNodeUtil();
        Integer result = instance.getKthFromEndListConvert(input, k);
        assertEquals(expected, result);
    }
    
    
}
