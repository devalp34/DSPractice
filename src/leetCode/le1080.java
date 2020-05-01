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
    TreeNode ptr = null;
    public TreeNode sufficientSubset(TreeNode root, int limit) 
    {
        if(root == null) return ptr;
        if(t(root,limit,0)) return root;
        else return null;
    }
    
    public boolean t(TreeNode node,int target,int sum)
    {
        if(node == null) return sum >= target;
        sum += node.val;
        boolean l = t(node.left,target,sum);
        boolean r = t(node.right,target,sum);
        if(!l) node.left = null;
        if(!r) node.right = null;
        if(node.left == null && node.right == null)
            return l & r;
        else return true;
    }
}
