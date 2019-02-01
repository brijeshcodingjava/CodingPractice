package algo.dstruct.linklist;

public class Node {
	int data;
	Node next;
	Node previous;
	
	public Node()
	{
		
	}
	
	public Node( int data )
	{
		this.data = data;
	}
	
	public void displayNode()
	{
		System.out.println( data + " ");
	}
}
