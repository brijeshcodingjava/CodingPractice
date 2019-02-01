package algo.dstruct.linklist;

public class Test {

	public static void main( String ...args )
	{
		Node nodeA = new Node();
		nodeA.data = 5;
		
		Node nodeB = new Node();
		nodeB.data = 6;
		
		Node nodeC = new Node();
		nodeC.data = 7;
		
		Node nodeD = new Node();
		nodeD.data = 8;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		//System.out.println( "Length : " + length( nodeA ));
		
		
		
	}
	
	public static int length( Node node )
	{
		int length = 0;
		Node holder = new Node();
		holder.next = node;
		
		
		while( node != null )
		{
			length++;
			node = node.next;
		}
		
		node = holder.next;
		
		return length;
	}
}
