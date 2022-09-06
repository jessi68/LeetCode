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
    List<Integer> inorderResult;
    int first;
    int second;
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        inorderResult.add(root.val);
        inOrder(root.right);
    }
    
    private void inOrderAndSwap(TreeNode root) {

        if(root == null) {
            return;
        }
        inOrderAndSwap(root.left);
        if(root.val == first) {
        
            root.val = second;
        } else if(root.val == second) {
   
            root.val = first;
        }
        inOrderAndSwap(root.right);
    }
     
    
    public void recoverTree(TreeNode root) {
        inorderResult = new ArrayList<Integer>();
        TreeNode curr = root;
        inOrder(curr);
        
        boolean occured = false;
        
        int length = inorderResult.size();

        for(int i = 0; i < length - 1; i++) {
            
            if(inorderResult.get(i) > inorderResult.get(i + 1)) {
                if(occured == false) {
                    occured = true;
                    first = inorderResult.get(i);
                    second = inorderResult.get(i + 1);
                } else {
                    second = inorderResult.get(i + 1);
                }
            }
        }
        
      
        
         inOrderAndSwap(root);
        
            
    }
}

// a1, a2, a3, ....., an
// a2, a1, a3, ....., an

// a3, a2, a1, a4, a5, 

//  ai-1 , aj, ai+1, ... aj-1, ai, aj+1

// binary search tree 탐색해서 정렬된 상태로 가져오는 거 이거는 멀티 스레딩이든 프로세싱이든 굳이 의미 없지??
// a1, a10, a3, a4, a5, a6, a9, a1 