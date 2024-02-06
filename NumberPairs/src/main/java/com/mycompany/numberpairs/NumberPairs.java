package com.mycompany.numberpairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Dan Brown
 */

public class NumberPairs {
    
    // uses hash maps to pair numbers that add up to a specific target sum together
    // ---> takes in a list of numbers as a parameter as well as the targeted sum 
    public List<HashSet> getSumPairs( List <Integer> numList, Integer targetSum) {
        List<HashSet> sumPairList = new ArrayList();
        HashMap<Integer, Integer> sumComplimentMap = new HashMap();
        
        // populate map that will contain a list of keys that exist within the numList,
        //      and their values being the compliment needed to achieve that targetSum (ie:  val = targetSum - num)
        for(Integer num : numList) {
            if(sumComplimentMap.get(num) == null) {
                Integer complimentSum = targetSum - num;
                sumComplimentMap.put(num, complimentSum);
            }
        }
       
        // loop through list again, and check to see now if the map contains the Compliment value as the Key
        for(Integer num : numList) {
             Integer complimentSumKey = sumComplimentMap.get(num);
             // if this exists in the map, then we know that the original list has both the original value AND also the compliment value
             if(sumComplimentMap.get(complimentSumKey) != null) {
                 HashSet pairSet = new HashSet();   // put both values into a set (for later duplicate removal)
                 pairSet.add(num);
                 pairSet.add(complimentSumKey);
                 sumPairList.add(pairSet);      // add set to the sumPair list
             }
        }
        
        // now we just need to remove any duplicates...
        sumPairList = new ArrayList(new HashSet(sumPairList));
        return sumPairList;
    }


    public static void main(String[] args) {
        NumberPairs numberPairs = new NumberPairs();
        List<Integer> testNumList = Arrays.asList(0,1,2,3,4,5);
        Integer targetSum = 5;
        List<HashSet> sumPairsList = numberPairs.getSumPairs(testNumList, targetSum);
        
        System.out.println("testNumList: " + testNumList);
        System.out.println("targetSum: " + targetSum);
        System.out.println("sumPairsList: " + sumPairsList);
        
    }
    
}
