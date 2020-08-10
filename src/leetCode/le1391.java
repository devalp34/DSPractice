class Solution {
    public boolean hasValidPath(int[][] grid) {
        int colLen = grid.length, rowLen = grid[0].length;
        if(colLen == 1 && rowLen == 1) return true;
        
        HashMap<Integer,List<String>> hm = new HashMap<>();
        hm.put(1,Arrays.asList("left","right"));
        hm.put(2,Arrays.asList("above","below"));
        hm.put(3,Arrays.asList("left","below"));
        hm.put(4,Arrays.asList("below","right"));
        hm.put(5,Arrays.asList("left","above"));
        hm.put(6,Arrays.asList("above","right"));
        
        boolean[][] v = new boolean[colLen][rowLen];
        Queue<int[]> q = new LinkedList<>();
        int x = 0, y = 0;
        
        for(String s : hm.get(grid[0][0]))
        {
            int[] b = new int[2];
            if(s.equals("below"))
            {
                b[0] = x+1;
                b[1] = y;
                if(b[0] < colLen)
                {
                    q.add(b);
                    v[b[0]][b[1]] = true;
                }
            }
            else if(s.equals("right"))
            {
                b[0] = x;
                b[1] = y+1;
                if(b[1] < rowLen)
                {
                    q.add(b);
                    v[b[0]][b[1]] = true;
                }   
            }
        }
        
        while(!q.isEmpty())
        {
            int[] curr = q.peek();
            if(curr[0] == colLen - 1 && curr[1] == rowLen - 1) return true;
            int dig = grid[curr[0]][curr[1]];
            List<String> l = hm.get(dig);
            q.poll();
                    
            for(String s : l)
            {
                int[] b = new int[2];
                if(s.equals("left"))
                {
                    b[0] = curr[0];
                    b[1] = curr[1] - 1;
                    if(b[1] >= 0 && !v[b[0]][b[1]] && 
                      hm.get(grid[b[0]][b[1]]).contains("right"))
                    {
                        q.add(b);
                        v[b[0]][b[1]] = true;
                    }
                }
                else if(s.equals("right"))
                {
                    b[0] = curr[0];
                    b[1] = curr[1] + 1;
                    if(b[1] < rowLen && !v[b[0]][b[1]] && 
                       hm.get(grid[b[0]][b[1]]).contains("left"))
                    {
                        q.add(b);
                        v[b[0]][b[1]] = true;
                    }
                }
                else if(s.equals("above"))
                {
                    b[0] = curr[0] - 1;
                    b[1] = curr[1];
                    if(b[0] >= 0 && !v[b[0]][b[1]] && 
                      hm.get(grid[b[0]][b[1]]).contains("below"))
                    {
                        q.add(b);
                        v[b[0]][b[1]] = true;
                    }
                }
                else 
                {
                    b[0] = curr[0] + 1;
                    b[1] = curr[1];
                    if(b[0] < colLen && !v[b[0]][b[1]] && 
                      hm.get(grid[b[0]][b[1]]).contains("above"))
                    {
                        q.add(b);
                        v[b[0]][b[1]] = true;
                    }
                }
            }
        }
        
        return false;
    }
}
