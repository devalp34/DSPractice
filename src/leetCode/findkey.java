package leetCode;

import java.util.HashMap;
import java.util.Scanner;

public class findkey {
	
	HashMap<String, String> number = new HashMap<String, String>();
	String combination = "";
	public String phoneNumber(String str)
	{
		if(str == null) return null;
		number.put("2", "abc");
		number.put("3", "def");
		number.put("4", "ghi");
		number.put("5", "jkl");
		number.put("6", "mno");
		number.put("7", "pqrs");
		number.put("8", "tuv");
		number.put("9", "wxyz");
	
		
		for(int i = 0 ; i < str.length() ; i++)
		{
			String numberStr = number.get(str.substring(i, i+1));
			for(int j = 0 ; j < numberStr.length() ; j++)
			{
				combination += numberStr.substring(j, j+1);
				System.out.println(combination+" str is "+str);
				if(str.length() == 1)
				{
					//System.out.println("hello");
					combination = combination.substring(0,combination.length() - 1);
				}
				else phoneNumber(str.substring(i+1)); 
				
			}
			combination = "";
			return combination;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
	System.out.println("enter string");
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	findkey fk = new findkey();
	fk.phoneNumber(str);
	}
}
