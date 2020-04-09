/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {

    HashSet<Integer> hs = new HashSet<Integer>();
    public FindElements(TreeNode root) 
    {
        TreeNode head = root;
        head.val = 0;
        hs.add(0);
        contain(head);
    }
    
    public void contain(TreeNode r)
    {
        if(r == null) return;
        if(r.left != null)
        {
            r.left.val = (r.val*2) + 1;
            hs.add(r.left.val);
            contain(r.left);
        }
        if(r.right != null) 
        {
            r.right.val = (r.val*2) + 2;
            hs.add(r.right.val);
            contain(r.right);
        }
        return;
    }
    
    public boolean find(int target) 
    {
        if(hs.contains(target)) return true;
        else return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
