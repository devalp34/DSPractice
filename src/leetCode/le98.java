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
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        postOrder(root);
        return ans;
    }
    
    int[] postOrder(TreeNode node)
    {
        if(node == null) 
        {
            int[] a = {0,0};
            return a;
        }
        
        int[] min = postOrder(node.left);
        int[] max = postOrder(node.right);
     
        if(node.left == null && node.right == null)
        {
            int[] a = {node.val,node.val};
            return a;
        }
        
        if(node.left != null && min[1] >= node.val) ans = false;
        if(node.right != null && max[0] <= node.val) ans = false;
        
        int[] a = new int[2];
        
        if(node.left != null) a[0] = Math.min(min[0],node.val);
        else a[0] = Math.min(max[0],node.val); 
            
        if(node.right != null) a[1] = Math.max(max[1],node.val);
        else a[1] = Math.max(min[1],node.val);
        
        return a;
    }
}
