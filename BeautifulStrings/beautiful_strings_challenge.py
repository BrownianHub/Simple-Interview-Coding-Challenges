#!/usr/bin/env python 
'''
File name: beautiful_strings_challenge.py
Author: Dan Brown
Description:
-----------------------------------------------------------
A string is said to be beautiful if each letter in the string appears at most as many times as the previous letter in the alphabet within the string; ie: b occurs no more times than a; c occurs no more times than b; etc. Note that letter a has no previous letter.

Given a string, check whether it is beautiful.

Example

For inputString = "bbbaacdafe", the output should be solution(inputString) = true.

This string contains 3 as, 3 bs, 1 c, 1 d, 1 e, and 1 f (and 0 of every other letter), so since there aren't any letters that appear more frequently than the previous letter, this string qualifies as beautiful.

For inputString = "aabbb", the output should be solution(inputString) = false.

Since there are more bs than as, this string is not beautiful.

For inputString = "bbc", the output should be solution(inputString) = false.

Although there are more bs than cs, this string is not beautiful because there are no as, so therefore there are more bs than as.

Input/Output

[execution time limit] 4 seconds (py3)

[memory limit] 1 GB

[input] string inputString

A string of lowercase English letters.

Guaranteed constraints:
3 ≤ inputString.length ≤ 50.

[output] boolean

Return true if the string is beautiful, false otherwise.
-----------------------------------------------------------

'''

import string


def solution(inputString):
    frequencies = character_frequency(inputString)
    alphabet_list = list(string.ascii_lowercase)

    # this way, we still keep order of original alphabet_list, but as a list of frequencies of each letter
    alphabet_list_freq = [frequencies.get(x,0) for x in alphabet_list]     

    print("alphabetListFreq: " + str(alphabet_list_freq))

    previous_frequency = alphabet_list_freq[0]     # 'a' frequency
    if previous_frequency == 0:      # 'a' occurs 0 times, so not beautiful
        return False
    
    for letter_freq in alphabet_list_freq:        
        if (letter_freq > previous_frequency):
            return False
        else:
            previous_frequency = letter_freq
        
    return True



def character_frequency(inputString):
    frequencies = {}
    for char in inputString:
        if char in frequencies:
            frequencies[char] += 1
        else:
            frequencies[char] = 1
    
    return frequencies




def main():
    test_list = [ 
        ("bbc", False),  
        ("bbbaacdafe", True), 
        ("aabbb", False),  
        ("a", True), 
        ("bbbaacdafez", False), 
        ("aaz", False), 
        ("azz", False),  
        ("x", False),
        ("", False), 
        (string.ascii_lowercase, True)
        ]

    for (input, output) in test_list:
        x = solution(input)
        print("input: " + input + " ; "  + " should be: " + str(output) + " ; " + "Was: " + str(x))
        assert(x == output)



if __name__ == "__main__":
    main()