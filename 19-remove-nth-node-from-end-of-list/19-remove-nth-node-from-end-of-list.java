/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Pair {
    private ListNode tail;
    private int number;

    public Pair(ListNode tail, int number) {
        this.tail = tail;
        this.number = number;
    }
    
    public void setTail(ListNode tail) {
        this.tail = tail;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    public ListNode getTail() {
        return tail;
    }
    
    public Integer getNumber() {
        return number;
    }

}

class Solution {
    
    private Pair getSizeAndTail(ListNode head) {
        ListNode current = head;
        Pair pair = new Pair(null, -1);
        int size = 1;
        
        while(current != null  && current.next != null) {
        
            current = current.next;
            size += 1;
        }
        
        pair.setNumber(size);
        pair.setTail(current);
        
        return pair;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        Pair sizeAndTail = getSizeAndTail(head);
        ListNode tail = sizeAndTail.getTail();
        ListNode prev = null;
        int size = sizeAndTail.getNumber();
        
        int count = -1;
        
        while(current != null) {
            count += 1;
            
            if(count + n == size) {
                if(current == head) {
                    head = head.next;
                } else{
                    prev.next = current.next;
                }
                break;
            } 
            prev = current;
            current = current.next;
        }
        
        
        return head;
    }
}