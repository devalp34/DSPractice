package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class treeConstruct {
	
	Node prev,root;
	int[] input = {3,2,1};
	Integer[] ip = new Integer[input.length];
	int i=0,j=0,max = 0,index = 0;

	class Node
	{
		int value;
		Node left;
		Node right;
		Node(int n)
		{
			this.value = n;
			left = null;
			right = null;
		}
	}
	
	public void createTree()
	{
		for(i = 0 ; i < input.length ; i++)
		{
			ip[i] = input[i];
			if(max < input[i])
			{
				max = input[i];
				index = i;
			}
		}
		System.out.println("first max is "+max);
		Node node = new Node(max);
		root = prev = node;
		ip[index] = null;
		int iterate = index - 0;
		i = 0;
		
		while(i != iterate)
		{
			int high = findMax(0, iterate,ip);
			Node node1 = new Node(high);
			if(i == 0)
			{
				prev.left = node1;
				System.out.println("from left part of left child "+node1.value);
			}
			else
			{
				prev.right = node1;
				System.out.println("from left part of right child "+node1.value);
			}
			i++;
			prev = node1;
		}
		
		int rpart = ip.length - index - 1;
		i=0;
		prev = root;
		while(i != rpart)
		{
			int high = findMax(rpart, ip.length,ip);
			Node node1 = new Node(high);
			if(i == 0)
			{
				prev.right = node1;
				System.out.println("from right part of left child "+node1.value);
			}
			else prev.left = node1;
			i++;
			prev = node1;
		}
		
		Node ptr = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(ptr);
		recursivePrint(queue);
	}
	
	private void recursivePrint(Queue<Node> queue)
	{
		Queue<Integer> data = new LinkedList<Integer>();
		data.add(6);
		while(queue.size() != 0)
		{
			Node ptr = queue.peek();
			System.out.println(ptr.value);
			System.out.println(data);
			queue.poll();
			data.poll();
			if(ptr.left != null)
			{
				System.out.println(" from left part ");
				queue.add(ptr.left);
				data.add(ptr.left.value);
			}
			System.out.println("ptr.value is "+ptr.value+" ptr.right "+ptr.right);
			if(ptr.right != null)
			{
				System.out.println(" from right part ");
				queue.add(ptr.right);
				data.add(ptr.right.value);
			}
		}
	}
	
	private int findMax(int i, int j, Integer[] ip) 
	{
		int max = 0, ptr = 0;
		while(i < j)
		{
			if(ip[i] ==null)
			{
				i++;
				continue;
			}
			if(max < ip[i])
			{
				max = ip[i];
				ptr = i;
			}
			i++;
		}
		ip[ptr] = null;
		return max;
	}
	
	public static void main(String[] args) {
	treeConstruct tc = new treeConstruct(); 	
	tc.createTree();
	//tc.printTree();
	}

}
