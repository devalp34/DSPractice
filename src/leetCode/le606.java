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
    StringBuilder sb = new StringBuilder("");
    public String tree2str(TreeNode t) {
        preOrder(t);
        if(sb.length() != 0)
        {
            sb.delete(0,1);
            sb.delete(sb.length()-1,sb.length());
        }
        return sb.toString();
    }
    
    public void preOrder(TreeNode node)
    {
        if(node == null) return;
        sb.append("("+Integer.toString(node.val));
        if(node.left == null && node.right == null)
        {
            sb.append(")");
            return;
        }
        if(node.left != null) preOrder(node.left);
        else 
        {
            sb.append("()");
            preOrder(node.right);
        }
        if(node.left != null) preOrder(node.right);
        sb.append(")");
        return;
    }
}
