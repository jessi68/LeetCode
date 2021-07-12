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
    
    public int depth(TreeNode root, int maxDepth) {
        
        if(root == null) {
            return maxDepth;
        }
        if(root.left == null && root.right == null) {
            return maxDepth;
        }
        
        if(root.left == null) {
            return depth(root.right, maxDepth + 1);
        }
        
        if(root.right == null) {
            return depth(root.left, maxDepth + 1);
        }
        
        int leftHeight = depth(root.left, maxDepth + 1);
        int rightHeight =  depth(root.right, maxDepth + 1);
        
        
        if(leftHeight >= rightHeight) {
            return leftHeight;
        }
        
        return rightHeight;
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else{
            return depth(root, 1);
        }
    }
}