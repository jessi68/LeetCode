/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    HashMap<Integer, TreeNode> valToParent = new HashMap<Integer, TreeNode>();
    
    TreeNode makeNodeLowerLevel(TreeNode target, int count) {
        while(count > 0) {
            target = valToParent.get(target.val);
            count--;
        }
        
        return target;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int levelOfP =  findLevelOfNode(root, p, 0);
        int levelOfQ = findLevelOfNode(root, q, 0);
        TreeNode pAnces = p;
        TreeNode qAnces = q;
        
        if(levelOfP > levelOfQ) {
            pAnces = makeNodeLowerLevel(pAnces, levelOfP - levelOfQ);
            
        } else{
            qAnces = makeNodeLowerLevel(qAnces, levelOfQ - levelOfP);
        }
        
        TreeNode lca;
        
        while(pAnces != qAnces) {
            pAnces = valToParent.get(pAnces.val);
            qAnces = valToParent.get(qAnces.val);
        }
        
        lca = pAnces;
        
        return lca;
    }
    
    int findLevelOfNode(TreeNode root, TreeNode p, int level) {
        
        if(root == null) {
            return -1;
        }
        
        if(root.val == p.val) {
            return level;
        }
        int leftAnswer;
        int rightAnswer;
        
        if(root.left != null) {
            valToParent.put(root.left.val, root);
            leftAnswer = findLevelOfNode(root.left, p, level + 1);
            if(leftAnswer != -1) {
                return leftAnswer;
            }
        }
        
        if(root.right != null) {
            valToParent.put(root.right.val, root);
            rightAnswer = findLevelOfNode(root.right, p, level + 1);
            if(rightAnswer != -1) {
                return rightAnswer;
            }
        }
        
        return -1;
    }
}