
package com.mycompany.listnodes;

import java.util.ArrayList;


/**
 *
 * @author Dan Brown
 */
public class ListNodeUtil {
    
    
     // Reverse a linked list
    public ListNode reverseList(ListNode head) {
        ListNode current = head;        // pointer to current list node
        ListNode prev = null;           // pointer to "previous" list node
        
        // if our input is null, then just return the head
        if (head == null) {
            return head;
        }
        // simple temp node switching
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    
    // Get the Kth element from the end of a linked list (more specifically, ListNode linked-list)
    // --> This is the "two-pointer" solution
    public Integer getKthFromEnd(ListNode originalList, Integer k) {
        ListNode current = originalList;        // pointer to current list node
        ListNode kPointer = originalList;         // pointer to k-th from end list node
        int returnDefault = -1;         // what we return as a default in the case of bad inputs or other reasons
        
        // in case we have bad inputs:
         if ( originalList == null || k < 0 ) {
             return returnDefault;
         }
        
        int kCounter = 0;
        while (current != null) {       // loop through the original list
            if(kCounter > k) {      // only "increment" the k pointer to next element when we have moved k steps already
                kPointer = kPointer.next;
            }
            current = current.next;
            kCounter++;
        }
        // Just in case our kPointer is null at the end of it all, then return the default.
        // --> OR if kCounter <= k, which would mean we traversed the entire list, but still have not reached k from the end
        if ( kPointer == null || kCounter <= k) {
            return returnDefault;
        }
        return kPointer.val;
    }
   
    
    // OR instead of doing all that, you could just convert everything into a normal list, and then do:
    // return newList.get(newList.size() - k-1);  <--- which defeats the purpose of the exercise, but so do these types of tech "challenges"
    // --> higher space complexity with this one though -> O(n) instead of O(1) like above
    // ---> but, otherwise, for time complexity, they are about the same --> O(n);
    //          ---> this one slightly slower since in a worse case scenario (like k = length of list), then it will be O(2*n), but that's still O(n).
     public Integer getKthFromEndListConvert(ListNode originalList, Integer k) {
        ArrayList<Integer> newList = new ArrayList();
        ListNode current = originalList;        // pointer to current list node
        int returnDefault = -1;         // what we return as a default in the case of bad inputs or other reasons
        
        // in case we have bad inputs:
         if ( originalList == null || k < 0 ) {
             return returnDefault;
         }
        // loop through and shove everything into list
        while (current != null) {
            newList.add(current.val);
            current = current.next;
        }   
        if (k >= newList.size()) {      // if k is greater or equal to the size of the new list, then we cant get to the element, so return default
            return returnDefault;
        }
        return newList.get(newList.size() - k-1);
     }
    
    
}
