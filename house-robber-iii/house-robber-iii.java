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
    
    public int rob(TreeNode root) {
    if(root == null)
    return 0;

    int[] result = recursive(root);
    return Math.max(result[0], result[1]);
    }

    public int[] recursive(TreeNode root){
        
    if(root == null){
    int[] result = {0, 0};
    return result;
    }

    int[] result = new int[2];
    int[] left = recursive(root.left);
    int[] right = recursive(root.right);

    // result[0] is when root is selected, result[1] is when not. 
    result[0] = root.val + left[1] + right[1];
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return result;
    }

}