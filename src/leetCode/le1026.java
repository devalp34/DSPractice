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
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        t(root);
        return diff;
    }
    
    public List<Integer> t(TreeNode node)
    {
        if(node == null) return new LinkedList<Integer>();
        List<Integer> left = t(node.left);
        List<Integer> right = t(node.right);
        List<Integer> l = new LinkedList<Integer>();
        if(left.size() == 0 && right.size() == 0)
        {
            l.add(node.val);
            l.add(node.val);
            return l;
        }
        if(left.size() == 0) 
        {
            diff = Math.max(diff,Math.abs(right.get(0) - node.val));
            diff = Math.max(diff,Math.abs(right.get(1) - node.val));
            l.add(Math.min(right.get(0),node.val));
            l.add(Math.max(right.get(1),node.val));
            return l;
        }
        if(right.size() == 0) 
        {
            diff = Math.max(diff,Math.abs(left.get(0) - node.val));
            diff = Math.max(diff,Math.abs(left.get(1) - node.val));
            l.add(Math.min(left.get(0),node.val));
            l.add(Math.max(left.get(1),node.val));
            return l;
        }
        l.add(Math.min(node.val,Math.min(left.get(0),right.get(0))));
        l.add(Math.max(node.val,Math.max(left.get(1),right.get(1))));
        diff = Math.max(diff,Math.max(Math.abs(node.val-l.get(0)),Math.abs(node.val-l.get(1))));
        return l;
    }
}
