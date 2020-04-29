class Solution {
    public String alphabetBoardPath(String target) 
    {
        StringBuilder sb = new StringBuilder("");
        int rows = 0, cols = 0;
        for(char c : target.toCharArray())
        {
            int i = (int) c;
            int ro = (i-97) / 5;
            int co = (i-97) % 5;
            if(rows == ro && cols == co) sb.append("!");
            else
            {
                if(rows < ro)
                {
                    if(ro == 5)
                    {
                        while(cols != co)
                        {
                            sb.append("L");
                            cols--;
                        }
                        while(rows != ro)
                        {
                            sb.append("D");
                            rows++;
                        }
                        sb.append("!");
                        continue;
                    }
                    while(rows != ro) 
                    {
                        sb.append("D");
                        rows++;   
                    }
                }
                else
                {
                    while(rows != ro) 
                    {
                        sb.append("U");
                        rows--;
                    }
                }
                
                if(cols < co)
                {
                    while(cols != co)
                    {
                        sb.append("R");
                        cols++;
                    }
                }
                else
                {
                    while(cols != co)
                    {
                        sb.append("L");
                        cols--;
                    }
                }    
                sb.append("!");
            }
        }
        
        return sb.toString();
    }
}
