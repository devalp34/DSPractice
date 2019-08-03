package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class splitString {

	public static void main(String[] args) {
		String[] queries = {"FooBar",
							"FooBarTest",
							"FootBall",
							"FrameBuffer",
							"ForceFeedBack"};
		String pattern = "FB";
		ArrayList<Boolean> ans = new ArrayList<Boolean>();
        String[] str;
        String[] str1 = pattern.split("(?=[A-Z])");
        HashMap<Integer,String> hmstr = new HashMap<Integer,String>();
        HashMap<Integer,String> hmptn = new HashMap<Integer,String>();
        int key = 0;
        
        for(int i = 0 ; i< str1.length ; i++)
        {
        	if(Character.isLowerCase(str1[i].charAt(0))) continue;
        	else
        	{
        		hmptn.put(key, str1[i]);
        		key++;
        	}
        	
        }
        
        System.out.println("hmptn size is "+hmptn.size());
        int j=0;
        key = 0;
        for(int i=0 ; i<queries.length ; i++)
        {
            str = queries[i].split("(?=[A-Z])");
            
            for(int m = 0 ; m < str.length; m++)
            {
            	if(Character.isLowerCase(str[m].charAt(0))) continue;
            	else
            	{
            		hmstr.put(key, str[m]);
            		key++;
            	}
            }
            System.out.println("hmstr is "+hmstr+"hmstr size is "+hmstr.size());
            key = 0;
            
            System.out.println("ans is "+ans);
            hmstr.clear();
//            while(j < hmstr.size() )
//            {
//            	String tmp = hmstr.get(j);
//            	String tmp1 = hmptn.get(j);
//            	
//            	if(tmp.length() < tmp1.length())
//            	{
//            		ans.add(false);
//            		break;
//            	}
//            	int k=0,l=0;
//            	while(k < tmp.length() && l < tmp1.length())
//            	{
//            		if(tmp.charAt(k) == tmp1.charAt(l))
//            		{
//            			l++;
//            			k++;
//            		}
//            		else k++;
//            	}
//            	
//            	if(l < tmp1.length())
//            	{
//            		ans.add(false);
//            		break;
//            	}
//            	k=0;
//            	l=0;
//            	if(j == hmstr.size() - 1)
//            	{
//            		ans.add(true);
//            	}
//            	j++;
//            }
//            j=0;
            
        }
	}

}
