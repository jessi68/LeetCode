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
    TreeNode root;
    public TreeNode deleteNode(TreeNode root, int key) {
        this.root = root;
        
     return findAndDeleteNode(root, key);
    }
    
    TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }
    
    public TreeNode findAndDeleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        
        if(root.val == key) {
             if (root.left == null && root.right == null) {
                root = null;
             } else if(root.left == null) {
                 TreeNode temp = root;
                 root = root.right;
                 temp = null;
             } else if(root.right == null) {
                 TreeNode temp = root;
                 root = temp.left;
                 temp = null;
             } else{
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = findAndDeleteNode(root.right, root.val);
             }
           
        } else if(root.val > key) {
            root.left = findAndDeleteNode(root.left, key);
        } else {
            root.right =  findAndDeleteNode(root.right, key);
        }
        
         return root;
    }
}