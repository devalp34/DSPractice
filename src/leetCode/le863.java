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
    HashMap<TreeNode,TreeNode> relation = new HashMap<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root == null) return new LinkedList<Integer>();
        
        traverse(root,null);
        
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        
        int currLevel = 0;
        TreeNode currLast = target, nextLast = target;
        
        while(currLevel < K && !q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left != null && !visited.contains(node.left))
            {
                q.add(node.left);
                nextLast = node.left;
                visited.add(node.left);
            }
            
            if(node.right != null && !visited.contains(node.right))
            {
                q.add(node.right);
                nextLast = node.right;
                visited.add(node.right);
            }
            
        if(relation.get(node) != null && !visited.contains(relation.get(node)))
            {
                q.add(relation.get(node));
                nextLast = relation.get(node);
                visited.add(relation.get(node));
            }
            
            if(currLast == node) 
            {
                currLast = nextLast;
                currLevel++;
            }
        }
        
        List<Integer> ans = new LinkedList<>();
        while(!q.isEmpty()) ans.add(q.poll().val);
        
        return ans;
    }
    
    void traverse(TreeNode child, TreeNode parent)
    {
        if(child == null) return;
        
        relation.put(child,parent);
        
        traverse(child.left,child);
        traverse(child.right,child);
        return;
    }
}    
