package leetCode;

import java.util.ArrayList;
import java.util.Scanner;

class Node
{
	int data;
	Node left;
	Node right;
	Node(int n)
	{
		this.data = n;
		left = null;
		right = null;
	}
	
}

public class treeStructure {

	Node prev,temp,head;
	ArrayList<Integer> lst = new ArrayList<Integer>();
	ArrayList<Integer> childlst = new ArrayList<Integer>();
	int depth1=0;
	public void addChild(int n)
	{
		Node node = new Node(n);
		lst.add(n);
		if(lst.size() == 1)
		{
			prev = node;
			head = node;
		}
		else addRecursive(prev, node);
	}
		
	public void searchNum(int n)
	{
		if(lst.contains(n)) System.out.println(" Contain ");
		else System.out.println(" Not Contain ");
	}
	
	
	public int findDepth()
	{
		Node ptr = head;
		int depth = maxDepth(ptr);
		System.out.println(" Number of Child is "+childlst.size()+" child is "+childlst);
		return depth;
	}
	
	private int maxDepth(Node ptr)
	{
		if(ptr == null) return 0;
		int ldepth = maxDepth(ptr.left);
		int rdepth = maxDepth(ptr.right);
		int depth = Math.max(ldepth, rdepth);
		System.out.println(" depth data is "+ptr.data);
		if(depth == 0) childlst.add(ptr.data);
		return depth + 1;
	}
	
	private void addRecursive(Node current, Node val)
	{
		if(current.data > val.data) 
		{
			if(current.left == null) current.left = val;
			else addRecursive(current.left,val);
		}
		else 
		{
			if(current.right == null) current.right = val;
			else addRecursive(current.right,val);
		}
	}
	
	public static void main(String[] args) 
	{
		int con = 0,i=0;
		Scanner sc = new Scanner(System.in);
		treeStructure ts = new treeStructure();
		Integer[] input = {1,2}; 
		while(i<input.length)
		{
			if(input[i] == null)
			{
				i++;
				continue;
			}
			ts.addChild(input[i]);
			i++;
		}
		int depth = ts.findDepth();
		System.out.println("total depth is "+depth);
		System.out.println("Enter number that you want to search ");
		int ans = sc.nextInt();
		ts.searchNum(ans);
	//	ts.printTree();
	}

}
