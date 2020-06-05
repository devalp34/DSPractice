class Solution {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j] == word.charAt(0)) 
                    bt(board,word,i,j,new boolean[board.length][board[0].length],0);
                if(result) return result;
            }
        }
        return result; 
    }
    
    void bt(char[][] b, String s, int i, int j, boolean[][] v, int ptr)
    {
        if(ptr == s.length()) 
        {
            result = true;
            return;
        }
        
        if(result) return;
        
        if(i < 0 || i >= b.length || j < 0 || j >= b[0].length || v[i][j])
            return;
    
        if(b[i][j] == s.charAt(ptr)) v[i][j] = true;   
        else return;
        
        bt(b,s,i+1,j,v,ptr+1);
        bt(b,s,i-1,j,v,ptr+1);
        bt(b,s,i,j+1,v,ptr+1);
        bt(b,s,i,j-1,v,ptr+1);
        
        v[i][j] = false;
    }
}
