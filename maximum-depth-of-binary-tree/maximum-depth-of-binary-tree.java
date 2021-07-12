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
       
        int leftHeight = depth(root.left, maxDepth);
        int rightHeight =  depth(root.right, maxDepth);
        
        
        if(leftHeight >= rightHeight) {
            return leftHeight + 1;
        }
        
        return rightHeight + 1;
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else{
            return depth(root, 0);
        }
    }
}