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
    ArrayList<Integer> treeList = new ArrayList<Integer>();
    
    public void inOrderTree(TreeNode root) {
        if(root.left != null) {
            inOrderTree(root.left);
        }
        treeList.add(root.val);
        if(root.right != null) {
            inOrderTree(root.right);
        }
    }
    public boolean isValidBST(TreeNode root) {
        inOrderTree(root);
        int length = treeList.size();
        for(int i = 0; i < length - 1; i++) {
            if(treeList.get(i)  >= treeList.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
}