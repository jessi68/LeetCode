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
   public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return countingPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int countingPath(TreeNode root, int target) {
        int count = 0;
        if (root == null) {
            return count;
        }
        if (root.val == target) {
            count++;
        }

        count += countingPath(root.left, target - root.val);
        count += countingPath(root.right, target - root.val);
        return count;
    }
}