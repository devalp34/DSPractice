import java.util.*;
public class Main {

    void calc(List<Integer> a)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int size = a.size(), temp = 0, ans = 0, curr = 0, sa = 0, ma = 0;
        hm.put(a.get(0),1);
        boolean flag = false;

        for(int i = 1 ; i < size ; i++)
        {
            curr = a.get(i);
            hm.put(curr,hm.getOrDefault(curr,0)+1);

            if(hm.get(curr) > 3) flag = true;
            
            if(curr - a.get(sa) < 10)
            {
                if(i - sa >= 20) flag = true;
            }
            else
            {
                while(curr - a.get(sa) >= 10)
                {
                    temp = hm.get(a.get(sa));
                    sa += temp;
                }
                if(i - sa >= 20) flag = true;
            }

            if(curr - a.get(ma) < 60)
            {
                if(i - ma >= 60) flag = true;
            }
            else
            {
                while(curr - a.get(ma) >= 60)
                {
                    temp = hm.get(a.get(ma));
                    ma += temp;
                }
                if(i - ma >= 60) flag = true;
            }

            if(flag)
            {
                ans++;
                System.out.println("curr :"+curr+" sa :"+sa+" ma:"+ma+" i :"+i);
            } 
            flag = false;
        }
        System.out.println("ans :"+ans);
    }

    public static void main(String args[]) {
        System.out.println("Hello World!");
        int[] a = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7};
        List<Integer> l = new LinkedList<>();
        for(int i : a) l.add(i);
        Main m = new Main();
        m.calc(l);
    }
}
