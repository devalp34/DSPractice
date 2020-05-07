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
    HashMap<TreeNode,TreeNode> hm = new HashMap<>(); // Parent-child
    HashMap<Integer,TreeNode> hm1 = new HashMap<>(); // val to Node
    HashMap<Integer,Integer> hm2 = new HashMap<>(); // val to len
    
    public boolean isCousins(TreeNode root, int x, int y) {
        hm.put(root,null);
        hm1.put(root.val,root);
        hm2.put(root.val,0);
        pc(root, root.left,1);
        pc(root,root.right,1);
        if((hm.get(hm1.get(x)) != hm.get(hm1.get(y))) && hm2.get(x) == hm2.get(y)) return true;
        else return false;
    }
    
    public void pc(TreeNode parent,TreeNode child,int len)
    {
        if(child == null) return;
        hm.put(child,parent);
        hm1.put(child.val,child);
        hm2.put(child.val,len);
        pc(child,child.left,len+1);
        pc(child,child.right,len+1);
        return;
    }
}
