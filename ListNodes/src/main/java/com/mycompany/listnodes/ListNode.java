
package com.mycompany.listnodes;

import java.util.List;

/**
 *
 * @author Dan Brown
 */
public class ListNode {
        // Ideally, these should be private and using getters and setters, but most ListNodes interview coding questions have them
        //      defined specifically like this, which is stupid, but hey, so are coding interviews.
        int val;
        ListNode next;
        
        public  ListNode() {}       // typical constructor
        
        // Added the following constructors compared to what you usually have defined for ListNodes interview coding questions 
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        
        // constructor that takes in a list and produces the ListNode version
        public ListNode(List<Integer> regularList) {
            ListNode temp = this.convertListToListNode(regularList);
            this.val = temp.val;
            this.next = temp.next;      
        }
        
        // Converts a list into ListNodes
        private ListNode convertListToListNode(List<Integer> regularList) {
            if (regularList == null || regularList.isEmpty()) {
                return null;
            }

            ListNode temp  = new ListNode(0);       // some default value
            ListNode current = temp;

            for (Integer val : regularList) {
                current.next = new ListNode(val);
                current = current.next;
            }

            return temp.next;      // chop off the "default" head and return the resulting ListNode
        }


        // For comparing ListNodes to each other
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            ListNode other = (ListNode) obj;    // other object
            ListNode copy = this;       // create copy of this

            // loop through all next ListNodes to check if they are also equal
            while (copy.next != null) {
                if (other.next == null) {
                    return false;
                } 
                if(!(other.next.equals(copy.next))) {       // if not, then return false
                    return false;
                }
                copy= copy.next;
                other = other.next;
            }
            return true;
        }

        // For printing out a ListNode linked-list
        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
        
}


    

