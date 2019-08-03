package leetCode;

import java.util.HashSet;

public class strToNumber {

	public void findOrder(int[] num)
	{
		int match = 0;
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0 ; i < num.length-1 ; i++)
		{
			if(num[i] == num[i+1]) match++;
			else break;
		}
		
		if(match == num.length-1) System.out.println("length is 1");
		int aOrder = 0 , dOrder = 0, count = 1, prev = 0, ptr = 1;
		
		while(prev != 0)
		{
			prev  = num[ptr-1] - num[ptr];
			ptr++;
		}
		for(int i = ptr ; i < num.length ; i++)
		{
			int diff = num[i-1] - num[i];
			if(diff == 0) continue;
			if(prev == diff) continue;
			if(prev < 0 && diff < 0)
			{
				aOrder++;
				continue;
			}
			else if(prev > 0 && diff > 0)
			{
				dOrder++;
				continue;
			}
			else
			{
				if(aOrder > 0 || dOrder > 0)
				{
					count++;
					aOrder = dOrder = 0;
					prev = diff;
				}
				else
				{
					count++;
					prev = diff;
				}
			}
		}
		System.out.println("longest length is "+count);
	}
	
	public static void main(String[] args) {

		int[] nums = {0,0,0,0,0};
		strToNumber sn = new strToNumber();
		sn.findOrder(nums);
	}

}
