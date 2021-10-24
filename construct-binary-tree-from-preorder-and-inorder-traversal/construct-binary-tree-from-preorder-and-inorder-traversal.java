/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] preorders, int[] inorders) {
        int preStart =0;
        int preEnd = preorders.length-1;
        int inStart = 0;
        int inEnd = inorders.length-1;
 
        return buildTree(preorders, preStart, preEnd, 
                     inorders, inStart, inEnd);

    }
    
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
                              int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)  {
            return null;
        }
 
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
 
        int target=0; 
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootValue) {
                target = i;
                break;
            }
        }
 
        root.left = buildTree(preorder, preStart+1, preStart+1-inStart+target-1, 
                          inorder, inStart, target-1 );
        
        root.right = buildTree(preorder, preStart+1-inStart + target, preEnd, 
                           inorder, target+1, inEnd);
 
        return root;
    }

}