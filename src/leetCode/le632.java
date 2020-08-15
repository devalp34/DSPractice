class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int numsLen = nums.size();
        if(numsLen == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        
        PriorityQueue<Node> pq = new PriorityQueue<>((e1,e2) -> e1.val - e2.val);
        int diff = Integer.MAX_VALUE, max = 0, ele = 0, ans_min = 0, ans_max = 0;
        
        int[] len = new int[numsLen];
        
        for(int i = 0 ; i < numsLen ; i++)
        {
            ele = nums.get(i).get(0);
            pq.add(new Node(ele, i, 0));
            max = Math.max(max, ele);
            len[i] = nums.get(i).size();
        }
        
        while(!pq.isEmpty())
        {
            Node curr = pq.poll();
            if(diff > max - curr.val)
            {
                diff = max - curr.val;
                ans_max = max;
                ans_min = curr.val;
            }
            
            if(len[curr.listIndex] - 1 == curr.currIndex) break;
            
            ele = nums.get(curr.listIndex).get(curr.currIndex+1);
            max = Math.max(max,ele);
            pq.add(new Node(ele, curr.listIndex, curr.currIndex + 1));
        }
        
        return new int[]{ans_min, ans_max};
    }
}

class Node
{
    int val;
    int listIndex;
    int currIndex;
    
    public Node(int i, int j, int k)
    {
        val = i;
        listIndex = j;
        currIndex = k;
    }
}
