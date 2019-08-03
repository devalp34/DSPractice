package leetCode;

import java.util.HashMap;
import java.util.Scanner;

public class binToDec {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] data = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
		String str = "";
		HashMap<Integer,Integer> hmp = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> hmans = new HashMap<Integer,Integer>();
		
		System.out.println("Enter the length");
		double len = sc.nextDouble();
		int n = (int)( Math.log(len) / Math.log(2.0));
		System.out.println("Log length is "+n);
		
		int[] tmp = new int[n];
		for(int i=0; i<n ;i++)
		{
			tmp[i] = (int)((Math.pow(2, i))-1);
			System.out.println(tmp[i]);
			str += Integer.toString(data[tmp[i]]);
			System.out.println(str);
			hmp.put(i, tmp[i]+1);
			System.out.println(hmp);
		}
		hmans.put(0, Integer.parseInt(str, 2));
		hmp.remove(0);
		System.out.println("hmans is "+hmans+"hmp is "+hmp);
		int key = 1,j=0;
		int limit = tmp[tmp.length-1];
		tmp[tmp.length-1] = tmp[tmp.length-1] + 1;
		System.out.println(tmp[tmp.length-1]);
		
		for(int i=1; i<=limit ;i++)
		{
			//System.out.println("i is "+i);
			while(key < hmp.size()+1)
			{
			//	System.out.println("hash key is "+hmp.get(key));
				if(i % hmp.get(key) == 0)
				{
					tmp[tmp.length - key ] ++;
					System.out.println(tmp[tmp.length - key ]);
				}
				key++;
			}
			key = 1;
			//making string from data and take the array number from tmp
			while(j < tmp.length)
			{
				str += Integer.toString(tmp[j]);
				j++;
			}
			tmp[tmp.length - 1]++;
			System.out.println(str);
			//hmans.put(i, Integer.parseInt(str, 2));
			str = "1";
		}
		System.out.println(hmans);
	}

}
