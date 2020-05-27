class Solution {
    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int n)
        {
            val = n;
            left = null;
            right = null;
        }
    }
    
    boolean result = true;
    HashSet<Integer> hs = new HashSet<>();
    
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        TreeNode root = new TreeNode(0);
        TreeNode ptr = root;
        tra(ptr, leftChild, rightChild);
        if(hs.size() == n) return result;
        else 
        {
            for(int i = 0 ; i < leftChild.length ; i++)
            {
                if(hs.contains(i)) continue;
                if(leftChild[i] == root.val) 
                {
                    ptr = new TreeNode(i);
                    ptr.left = root;
                    root = ptr;
                    hs.add(i);
                }
                if(rightChild[i] == root.val)
                {
                    ptr = new TreeNode(i);
                    ptr.right = root;
                    root = ptr;
                    hs.add(i);
                }
            }
        }
        return hs.size() == n;
    }
    
    void tra(TreeNode node,int[] lc, int[] rc)
    {
        if(node == null) return;
        
        if(hs.contains(node.val) || lc[node.val] == node.val || rc[node.val] == node.val)
        {
            result = false;
            return;
        }
        
        hs.add(node.val);
        
        if(lc[node.val] == -1) node.left = null;
        else node.left = new TreeNode(lc[node.val]);
        
        if(rc[node.val] == -1) node.right = null;
        else node.right = new TreeNode(rc[node.val]);
        
        tra(node.left,lc,rc);
        tra(node.right,lc,rc);
        
        return;
    }
}
