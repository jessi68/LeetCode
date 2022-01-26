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
        public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == null && t == null;
        }

        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean sameTree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == null && t == null;
        
        return s.val == t.val && sameTree(s.left, t.left) && sameTree(s.right, t.right);
    }
}