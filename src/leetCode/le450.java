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
    TreeNode acr = null, parent = null;
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        TreeNode head = root;
        
        // checking node present or not
        if(!found(root, key, null)) return head; // if not present then return same head
        else
        {
            TreeNode t1 = acr.left;
            TreeNode t2 = acr.right;
            
            // if your root is targeted node
            if(parent == null)
            {
                if(t1 == null || t2 == null) 
                {
                    if(t1 == null) return t2;
                    if(t2 == null) return t1;
                }
                TreeNode p1 = traverse(t2, acr);
                p1.left = t1;
                return t2;
            }
            else if(parent.left == acr)
            {
                if(t1 == null || t2 == null) 
                {
                    if(t1 == null) parent.left = t2;
                    if(t2 == null) parent.left = t1;
                    return head;
                }
                TreeNode p1 = traverse(t2,acr);
                p1.left = t1;
                parent.left = t2;
                return head;
            }
            else
            {
                if(t1 == null || t2 == null) 
                {
                    if(t1 == null) parent.right = t2;
                    if(t2 == null) parent.right = t1;
                    return head;
                }
                TreeNode p1 = traverse(t2,acr);
                p1.left = t1;
                parent.right = t2;
                return head;
            }
        }
    }
    
    TreeNode traverse(TreeNode child, TreeNode p)
    {
        if(child == null) return p;
        return traverse(child.left, child);
    }
    
    boolean found(TreeNode child, int k, TreeNode p)
    {
        if(child == null) return false;
        
        if(child.val == k) 
        {
            parent = p;
            acr = child;
            return true;
        }
        
        return found(child.left,k,child) || found(child.right,k, child);
    }
}
