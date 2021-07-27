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
    public List<Integer> recursiveInorderTraversal(TreeNode root, List<Integer> visited) {
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        if(root == null) {
            return newArray;
        }
        
        newArray.addAll(recursiveInorderTraversal(root.left, visited));
        newArray.add(root.val);
        newArray.addAll(recursiveInorderTraversal(root.right, visited));
        return newArray;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        return recursiveInorderTraversal(root, new ArrayList<Integer>());
    }
}