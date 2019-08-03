package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class finMax {

	public void makeStr(String str1)
	{
		String str = "abc";
		String tempStr = "";
		boolean left = true, right = true;
		HashMap<Integer,String> hmLeft = new HashMap<Integer,String>();
		HashMap<Integer,String> hmRight = new HashMap<Integer,String>();
		
//		if(str1.length() < str.length()) // return false;
//		if(str1.length() == str.length()) // return str1.equals(str);
//		
		hmLeft.put(1, "a");
		hmLeft.put(2, "ab");
		hmLeft.put(3, "bc");
		hmLeft.put(4, "c");
		hmRight.put(1, "c");
		hmRight.put(2, "bc");
		
		int index  = str1.lastIndexOf("abc"); 
		System.out.println(index);

		if(index == -1) left = false;
			
		//System.out.println("substring "+str1.substring(0, index));
		if(str1.substring(0, index).length() == 0) left = true;
		else if(str1.substring(0, index).length() < str.length())
		{
			if(hmLeft.containsValue(str1.substring(0, index))) left = true;
			else left = false;
		}
		else
		{
			String[] strbufleft = str1.substring(0, index).split("abc");
			for(int i = 0 ; i < strbufleft.length ; i++)
			{
				System.out.println("strbufleft is "+strbufleft[i].isEmpty());
				if(strbufleft[i].isEmpty()) 
				{
					left = true;
					System.out.println(" from blank ");
				}
				else
				{
					String sub = strbufleft[i];
					if(sub.length() < 3 && hmLeft.containsValue(sub))
					{
						left = true;
						System.out.println(" left sub is "+sub+" left is "+left);
					}
					else 
					{
						left = false;
						System.out.println("break left sub is "+sub+" left is "+left);
						break;
					}
				}
			}
		}
		
		if(str1.substring(index+3, str1.length()).length() == 0) right = true;
		else if(str1.substring(index+3, str1.length()).length() < str.length())
		{
			String sub = str1.substring(index+3, str1.length());
			if(hmRight.containsValue(sub)) right = true;
			else right = false;
		}
		else right = false;
		
		boolean ans = left && right;
		System.out.println("left is "+left+" right is "+right+"ans is "+ans);
		System.out.println("hmleft is "+hmLeft+" hmRight is "+hmRight);
	}
	public static void main(String[] args) {
		String str = "abcbcabc";
		finMax fm = new finMax();
		fm.makeStr(str);
	}
}
