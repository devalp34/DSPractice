package leetCode;

public class strHash {

	public void strOutput(int[] a, int l, int m)
	{
		int max = 0;
		for(int i = 0; i < a.length-l+1 ; i++)
		{
			int ltotal = findTotal(a,i,i+l);
			for(int j = l+i ; j < a.length-m+1 ; j++)
			{
				int mtotal = findTotal(a,j,j+m);
				if(max < ltotal+mtotal) max = ltotal+mtotal;
			}
		}
		
		for(int i = a.length - l ; i >= 0 ; i--)
		{
			int ltotal = findTotal(a,i,i+l);
			for(int j = 0 ; j < i-m ; j++)
			{
				int mtotal = findTotal(a,j,j+m);
				if(max < ltotal+mtotal) max = ltotal+mtotal;
			}
		}
		System.out.println("max is "+max);
	}
	
	public int findTotal(int[] a, int start, int end)
	{
		int total = 0;
		for(int i = start ; i < end ; i++)
		{
			total += a[i];
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		int[] a  = {2,1,5,6,0,9,5,0,3,8};
		int L = 4, m = 3;
		strHash sh = new strHash();
		sh.strOutput(a,L,m);
	}

}
