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

public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return ; 
        TreeNode left=root.left; 
        TreeNode right=root.right; 
        if(left!=null)
        {
            root.right=left; 
            root.left=null; 
            TreeNode rightMost=root.right; 
            while(rightMost!=null && rightMost.right!=null)
            {
                rightMost=rightMost.right; 
            }
            if(rightMost!=null) rightMost.right=right; 
        }
        flatten(root.right);
    }
}