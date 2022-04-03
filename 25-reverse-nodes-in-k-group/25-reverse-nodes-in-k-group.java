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
class Solution {
    
    ListNode head;
    int k;
    
    public ArrayList<ListNode> reverseGroup(ListNode root) {
        int count = 1;
        ArrayList<ListNode> headAndLast = new ArrayList<>();
        
        ListNode current = root;
        ListNode last;
        ListNode temp;
        ListNode lastNode = root;
        
        while(current.next != null) {
            current = current.next;
            count += 1;
            if(count == this.k) {
                break;
            }
        }
        
        
        if(count != this.k) {
            return headAndLast;
        } else{
            last = current;
            current = root;
            
            while(current != null && current.next != null) {
                
                temp = root;
                root = current.next;
                current.next = current.next.next;
                root.next = temp;
                
                
                if(root == last) {
                    break;
                }
            }
            
            headAndLast.add(root);
            headAndLast.add(current);
            
            return headAndLast;
        }
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        this.head = head;
        this.k = k;
        ListNode current = head;
        boolean isHeadUpdated = false;
        ArrayList<ListNode> headAndLast;
        ListNode prev = null;
        
        while(current != null) {
            headAndLast = reverseGroup(current);
            // head update 하기
            if(headAndLast.size() == 0) {
                break;
            } else{
                if(!isHeadUpdated) {
                    this.head = headAndLast.get(0);
                    isHeadUpdated = true;
                } 
                current = headAndLast.get(1);
                
                if(prev != null) {
                    prev.next = headAndLast.get(0);
                }
                
                prev = current;
            }
            current = current.next;
        }
        
        return this.head;
    }
}