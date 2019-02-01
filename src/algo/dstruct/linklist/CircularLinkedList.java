package algo.dstruct.linklist;

public class CircularLinkedList {
	
	Node first;
	Node last;
	 
	public CircularLinkedList() {}
	
	 
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void insertFirst( int data )
	{
		Node newNode = new Node( data );
		newNode.next = first;
		
		if( isEmpty() ) last = newNode;
		
		first = newNode;
	}
	
	public void insertLast( int data )
	{
		if( last != null )
		{
			Node newNode = new Node( data );
			
			last.next = newNode;
			last = newNode;
			return;
		}
		
		insertFirst( data );
		
	}
	
	public void printLinkedList()
	{
		Node holder = new Node();
		holder.next = this.first;
		
		System.out.print("[ ");
		while( this.first != null )
		{
			System.out.print( this.first.data + " ");
			first = first.next;
		}
		System.out.print("]");
		
		this.first = holder.next;
	}
	
	public int deleteFirst()
	{
		if( isEmpty() ) 
		{
			System.out.println("ERROR::: List is empty...");
			return -1;
		}
		
		Node removed = first;
		
		first = first.next;
		
		removed.next = null; 
		
		return removed.data;
	}
	
	public int deleteLast()
	{
		if( isEmpty() ) 
		{
			System.out.println("ERROR::: List is empty...");
			return -1;
		}
		
		Node holder = new Node();
		holder.next = this.first;
		
		while( this.first.next != null && this.first.next.next != null )
		{
			this.first = this.first.next;
		}
		
		int removed = this.first.next.data;
		
		this.first.next = null;
		
		this.first = holder.next;
		
		return removed;
	}
	
	public static void main( String ...args )
	{
		CircularLinkedList obj = new CircularLinkedList();
		
		obj.deleteFirst();
		
		obj.insertFirst( 6 );
		obj.insertLast( 5 );
		obj.insertFirst( 3 );
		obj.insertLast( 7 );
		
		obj.printLinkedList();
		
		obj.deleteFirst();
		
		obj.printLinkedList();
		
		obj.deleteLast();
		
		obj.printLinkedList();
	}
}
