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
    TreeNode root = null;
    HashMap<Integer,TreeNode> hm = new HashMap();
    HashMap<TreeNode,Integer> hm1 = new HashMap();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return root;
        root = new TreeNode(preorder[0]);
        int index = 0;
        for(int i =0 ; i < inorder.length ; i++)
        {
            if(inorder[i] == preorder[0])
            {
                index = i;
                break;
            }
        }
        hm.put(preorder[0],root);
        dfs(1,preorder,inorder,index);
        return root;
    }
    
    public void dfs(int j, int[] po, int[] io, int index)
    {
        int li = index;
        for(int i = 0 ; i < io.length ; i++)
        {
            if(hm.containsKey(io[i]))
            {
                li = i;
                continue;
            }
            if(io[i] == po[j])
            {
                TreeNode node = hm.get(io[li]);
                if(li < i)
                {
                    if(node.right != null) 
                    {
                        node = node.right;
                        while(node.left != null) node = node.left;
                        node.left = new TreeNode(io[i]);
                        node = node.left;
                    }
                    else
                    {
                        node.right = new TreeNode(io[i]);
                        node = node.right;
                    }
                }
                else 
                {
                    node.left = new TreeNode(io[i]);
                    node = node.left;
                }
                li = i;
                hm.put(io[i],node);
                hm1.put(node,i);
                break;
            }
        }
        if(j+1 < po.length) dfs(j+1,po,io,li);
        return;
    }
}
