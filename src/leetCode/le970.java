class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> l = new LinkedList<Integer>();
        if(x == 1 && y == 1) 
        {
            if(bound > 1)
            {
                l.add(2);
                return l;    
            }
            else return l;
            
        }
        int i = 0 , j = 0, xlimit = 0 , ylimit = 0 , temp = bound;
        while(temp >= x && x > 1)
        {
            temp = temp / x;
            xlimit++;
        }
        
        temp = bound;
        while(temp >= y && y > 1)
        {
            temp = temp / y;
            ylimit++;
        }
        
        if(x == 1)
        {
            int t = 0;
            while(ylimit >= 0)
            {
                t = (int) Math.pow(y,ylimit) + 1;
                if(t <= bound)l.add(t);
                ylimit--;
            }
            return l;
        }
        
        if(y == 1)
        {
            int t = 0;
            while(xlimit >= 0)
            {
                t = (int) Math.pow(x,xlimit) + 1;
                if(t <= bound)l.add(t);
                xlimit--;
            }
            return l;
        }
        boolean toggle = true;
        if(xlimit > ylimit) toggle = false;
        
        while(i <= xlimit || j <= ylimit)
        {
            if(i > xlimit)
            {
                i = 0;
                j++;
            }
            else if(j > ylimit)
            {
                j = 0;
                i++;
            }
            int t = (int) (Math.pow(x,i) + Math.pow(y,j));
            if(t <= bound && !l.contains(t)) l.add(t);
            if(toggle)
            {
                j++;
                if(i > xlimit) break;
            }
            else 
            {
                i++;
                if(j > ylimit) break;
            }
        }
        return l;
    }
}
