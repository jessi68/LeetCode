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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return customSymmetric(root, root);
        
    }
    
    public boolean customSymmetric(TreeNode original, TreeNode mirrored) {
        if(original == null && mirrored == null) {
            return true;
        }
        
        if(original == null || mirrored == null) {
            return false;
        }
        
        if(original.val != mirrored.val) {
            return false;
        }
        
        return customSymmetric(original.left, mirrored.right) && customSymmetric(original.right, mirrored.left);
    }
}