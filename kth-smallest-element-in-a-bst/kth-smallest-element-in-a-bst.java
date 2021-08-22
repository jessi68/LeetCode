/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int givenOrder;
    int result;
    int curOrder;
    void inorder(TreeNode cur) {
        if(cur == null) {
            return;
        }
        inorder(cur.left);
        curOrder += 1;
        if(curOrder == givenOrder) {
            result = cur.val;
            return;
        }
        inorder(cur.right);
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        givenOrder = k;
        curOrder = 0;
        inorder(root);
        return result;
    }
}