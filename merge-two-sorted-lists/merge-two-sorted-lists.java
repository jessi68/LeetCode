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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        	return null;
        }
        ListNode node = new ListNode(0);
        ListNode d = node;
        while (l1 != null || l2 != null) {
        	if (l1 == null) {
        		node.next = l2;
        		break;
        	} else if (l2 == null) {
        		node.next = l1;
        		break;
        	} else {
        		if (l1.val < l2.val) {
        			node.next = l1;
        			l1 = l1.next;
        		} else {
        			node.next = l2;
        			l2 = l2.next;
        		}
    			node = node.next;
        	}
        }//end while
        return d.next;
    }
}