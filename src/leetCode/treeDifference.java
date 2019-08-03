package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class treeDifference {

	/* --------------------    BFS Tree Structure    -------------------------------------------------*/
	
public class Node 
{
	int data;
	Node left;
	Node right;
	Node(int n)
	{
		data = n;
		left = null;
		right = null;
	}
}

int i=1;
Node root, ptr;
	public void createTree()
	{
		int[] ip = {2,1,5,4,10,8,9,7};
		ptr = constructTree(ip,0,ip.length);
		System.out.print("root is "+ptr.data);
		Queue<Node> q = new LinkedList<Node>();
//		Node node = new Node(ip[0]);
//		q.add(node);
//		root = ptr = node;
//		while(i < ip.length)
//		{
//			Node node1 = new Node(ip[i]);
//			Node node2 = q.poll();
//			q.add(node1);
//			node2.left = node1;
//			//System.out.println("node2.data is "+node2.data+" 2's left is "+node1.data);
//			i++;
//			if(i < ip.length)
//			{
//				Node node3 = new Node(ip[i]);
//				q.add(node3);
//				node2.right = node3;
//				//System.out.println("node2.data is "+node2.data+" 2's right is "+node3.data);
//				i++;
//			}
//			else break;
//		}
//		q.removeAll(q);
//		q.add(root);
//		printTree(q);
		q.add(ptr);
		printTree(q);
	}
	
	public Node constructTree(int[] ip, int start, int end)
	{
		if(start == end) return null;
		int index = findMax(ip, start, end);
		System.out.println("index is "+index);
		Node root = new Node(ip[index]);
	//	System.out.println("left node.data is "+root.data+" index is "+index);
		root.left = constructTree(ip,0,index);
		System.out.println("right node.data is "+root.data+" end is "+end);
		root.right = constructTree(ip,index+1,end);
		return root;
	}
	
	public int findMax(int[] ip, int i , int j)
	{
		int maxIndex = 0;
		int max = 0;
		while(i < j)
		{
			if(max < ip[i])
			{
				max = ip[i];
				maxIndex = i;
			}
			i++;
		}
		return maxIndex;
	}
	
	public void printTree(Queue<Node> q)
	{	
		int n = q.peek().data;
		Queue<Integer> data = new LinkedList<Integer>();
		data.add(n);
		while(q.size() != 0)
		{
			//System.out.println("data q is "+data);
			data.poll();
			Node ptr = q.poll();
			//System.out.println("ptr.data is "+ptr.data);
			if(ptr.left != null)
			{
				q.add(ptr.left);
		//		System.out.println("from "+ptr.data+" & left is "+ptr.left.data);
				data.add(ptr.left.data);
			}
			if(ptr.right != null)
			{
				q.add(ptr.right);
		//		System.out.println("from "+ptr.data+" & right is "+ptr.right.data);
				data.add(ptr.right.data);
			}
		}
	}
//	public void printTree(Queue<Node> q)
//	{
//		while(q.size() != 0)
//		{
//			Node ptr = q.poll();
//			System.out.println(ptr.data);
//			if(ptr.left != null) 
//			{
//				//System.out.println("ptr.data is "+ptr.data+" ptr.left.data is "+ptr.left.data);
//				q.add(ptr.left);
//			}
//			if(ptr.right != null)
//			{
//				//System.out.println("ptr.data is "+ptr.data+" ptr.right.data is "+ptr.right.data);
//				q.add(ptr.right);
//			}
//		}
//	}

	public static void main(String[] args) {
		treeDifference td = new treeDifference();
		td.createTree();
	}

}
