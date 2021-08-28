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
    
     TreeNode traversal(int nums[], int start, int end) {
        if (start > end){
            return null;
        }
        int mid = (start + end) / 2;
         
        TreeNode result = new TreeNode(nums[mid]);
        result.left = traversal(nums, start, mid - 1);
        result.right = traversal(nums, mid + 1, end);
        return result;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        return traversal(nums, 0, size - 1);
    }
}