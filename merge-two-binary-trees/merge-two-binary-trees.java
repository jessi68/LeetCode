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
        void preOrderAndMerge(TreeNode root1, TreeNode root2, TreeNode newTree) {
            TreeNode first = root1;
            TreeNode second = root2;
            

            if(first == null && second == null) {
                return;
            }

            if(first != null && second != null) {
                 newTree.val = (first.val + second.val);
            }
            else if(first == null) {
                newTree.val = (second.val);
            }
            else{
                newTree.val = (first.val);
            }
            
            if(first == null) {
                if(second.left != null) {
                    newTree.left = new TreeNode();
                    preOrderAndMerge(null, second.left, newTree.left);
                }
            }
            else if(second == null) {
                if(first.left != null) {
                    newTree.left = new TreeNode();
                    preOrderAndMerge(first.left, null, newTree.left);
                }
            }
            else if(first.left != null || second.left != null) {
                newTree.left = new TreeNode();
                preOrderAndMerge(root1.left, root2.left, newTree.left);
            }

            if(first == null) {
                if(second.right != null) {
                    newTree.right = new TreeNode();
                    preOrderAndMerge(null, second.right, newTree.right);
                }
            }
            else if(second == null) {
                if(first.right != null) {
                    newTree.right = new TreeNode();
                    preOrderAndMerge(first.right, null, newTree.right);
                }
            }
           else if(root1.right != null || root2.right != null) {
                newTree.right = new TreeNode();
                preOrderAndMerge(root1.right, root2.right, newTree.right);
            }

    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        
        ArrayList<Integer> answers = new ArrayList<>();
        if(root1 == null && root2 == null) {
            return null;
        } else{
            TreeNode newTree = new TreeNode();
            preOrderAndMerge(root1, root2, newTree);
            return newTree;
            
        }
        
    }
}