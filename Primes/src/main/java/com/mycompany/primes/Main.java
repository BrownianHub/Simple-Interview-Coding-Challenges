
package com.mycompany.primes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Brown
 */
public class Main {
    
        public static void main(String[] args) {

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrimeUtil primeUtil = new PrimeUtil();
        
        try {
            String line = br.readLine();       // Reading input from STDIN
            Integer numTestCases = Integer.valueOf(line);       // get first value which should be number of test cases total
            
            for (int i = 0; i < numTestCases; i++ ) {
                line = br.readLine();       // get next line which should be the next test case
                String result = primeUtil.removePrimeFrequencyChars(line);
                System.out.println(result);
            }
        } catch (IOException ex) {
            Logger.getLogger(PrimeUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
}
