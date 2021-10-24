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
       
        if(root==null) return; 
        TreeNode left=root.left; 
        TreeNode right=root.right; 
        
        if(left!=null)
        {
            root.right=left; 
            root.left=null; 
            TreeNode mostRightNode=root.right; 
            while(mostRightNode!=null && mostRightNode.right!=null)
            {
                mostRightNode=mostRightNode.right; 
            }
            if(mostRightNode!=null) mostRightNode.right=right; 
        }
        flatten(root.right);
    }
}/**
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
       
        if(root==null) return; 
        TreeNode left=root.left; 
        TreeNode right=root.right; 
        
        if(left!=null)
        {
            root.right=left; 
            root.left=null; 
            TreeNode mostRightNode=root.right; 
            while(mostRightNode!=null && mostRightNode.right!=null)
            {
                mostRightNode=mostRightNode.right; 
            }
            if(mostRightNode!=null) mostRightNode.right=right; 
        }
        flatten(root.right);
    }
}
