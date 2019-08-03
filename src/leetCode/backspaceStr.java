package leetCode;

//for(int i = 0 ; i < n.length ; i++)
//{
//	if(i % 2 == 0) oddSum += n[i];
//	else evenSum += n[i];
//}
//
//if(n.length % 2 == 0)
//{
//	if(oddSum < evenSum) high = evenSum;
//	else high = oddSum;
//	System.out.println("even length high is "+high);
//}
//else
//{
//	oddSum -= Math.min(n[0], n[n.length-1]);
//	if(oddSum < evenSum) high = evenSum;
//	else high = oddSum;
//	System.out.println("odd length high is "+high);
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class backspaceStr {

	public void foundHouse(int[] n)
	{
		int max = 0, index = 0, sum = 0, ptr =0;
		HashMap<Integer,int[]> hIndex = new HashMap<Integer,int[]>();
		int[] temp = new int[n.length];
		
		for(int i = 0 ; i < n.length ; i++)
		{
			temp[i] = n[i];
			int[] a = new int[2];
			if(i == 0)
			{
				a[0] = n.length-1;
				a[1] = 1;
				hIndex.put(i, a);
				continue;
			}
			if(i == n.length -1)
			{
				a[0] = n.length-2;
				a[1] = 0;
				hIndex.put(i, a);
			}
			else
			{
				a[0] = i-1;
				a[1] = i+1;
				hIndex.put(i, a);
			}
		}
		
		HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
			for(int i = 0 ; i < n.length ; i++)
			{
				max = Arrays.stream(n).max().getAsInt();
				if(max == -1) continue;
				index = 0;
				while(n[index] != max)
				{
					if(n[index] == max) break;
					index++;
				}
				int[] b = hIndex.get(index);
				if(!hs.containsValue(b[0]) && !hs.containsValue(b[1]))
				{
					sum += max;
					hs.put(ptr,index);
					n[index] = -1;
					//System.out.println("max is "+max+" & index is "+index+" sum is "+sum);
					ptr++;
				}
				else n[index] = -1;
				
			}
			System.out.println("sum is "+sum);
			System.out.println(hs);
			if(n.length > 5)
			{
			for(int i = 0 ; i < ptr ; i++)
			{
				int selectIndex = hs.get(i);
				int b[] = hIndex.get(selectIndex);

				if(selectIndex == 1 )
				{
					if(!hs.containsValue(n.length-1) && !hs.containsValue(b[1]+1))
					{
						int newtemp = temp[b[0]] + temp[b[1]];
						if(newtemp > temp[selectIndex])
						{
							sum -= temp[selectIndex];
							sum += newtemp;
						}
					}
					else continue;
				}
				
				if(selectIndex == n.length -2)
				{
					if(!hs.containsValue(b[0]-1) && !hs.containsValue(0))
					{
						int newtemp = temp[b[0]] + temp[b[1]];
						if(newtemp > temp[selectIndex])
						{
							sum -= temp[selectIndex];
							sum += newtemp;
						}
					}
					else continue;
				}
				
				else if(!hs.containsValue(b[0] -1) && !hs.containsValue(b[1]+1))
				{
					System.out.println("selectIndex is "+selectIndex+" n["+b[0]+"] is "+n[b[0]]+" n["+b[1]+"] is "+n[b[1]]+" & i is "+i);					int newtemp = n[b[0]] + n[b[1]];
					int newTemp = temp[b[0]] + temp[b[1]];
					System.out.println("newTemp is "+newTemp);
					if(newTemp > temp[selectIndex])
					{
						System.out.println("old sum is "+sum);
						sum -= temp[selectIndex];
						sum += newTemp;
						System.out.println("new sum is "+sum);
					}
					else continue;
					
				}
				else continue;
				
			}
			}
		System.out.println("sum is "+sum);
	}

public static void main(String[] args) {
	backspaceStr bs = new backspaceStr();
	int[] nums = {94,40,49,65,21,21,106,80,92,81,679,4,61,6,
	               237,12,72,74,29,95,265,35,47,1,61,397,52,72,37,51,1,81,45,435,7,36,57,86,81,72};
	bs.foundHouse(nums);
	}
}
