package algo.dstruct.linklist;

public class LinkedList {

	Node first;
	Node last;
	
	public LinkedList(){
		
	}
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	// We need to create a new node and then add the same to first position.
	// Forget about what is the value of first.
	// Just create new node and assign next variable to this new node created,
	// as that is the one going to be first node now onwords.
	public void insertFirst( int data )
	{
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		
		this.first = newNode;
		
		if( last == null ) last = newNode;
	}
	
	public Node deleteFirst()
	{
		if( isEmpty() ){
			System.out.println("Error: Linked list is empty ! ");
			return null;
		}
		// Remove first node.
		Node removed = this.first;
		// Move pointer to next node.
		first = first.next;
		// Remove the reference so that it won't have remaining list attached to it.
		removed.next = null;
		
		return removed;
	}
	
	public void insertLast( int data )
	{
		if( last != null )
		{
			Node newNode = new Node( data );
			last.next = newNode;
			last = newNode;
			
			// If only one element was added and then removed, in that case fist will be null,
			// So we have to make last to first as well.

			first = first == null ? last : first;
			
			return;
		}
		insertFirst( data );
	}
	
	// First store the current node chain or linked list into some holder variable
	// Cycle through list and check for next node is null? 
	// If yes insert the new node.
	
	public void insertLast2( int data )
	{
		Node holder = new Node();
		holder.next = this.first;
		
		while( this.first.next != null )
		{
			this.first = this.first.next;
		}
		
		Node newNode = new Node( data );
		this.first.next = newNode;
		
		this.first = holder.next;
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
	
	public static void main( String ...args )
	{
		LinkedList list = new LinkedList();
		list.insertFirst( 5 );
		//list.insertFirst( 6 );
		//list.insertFirst( 7 );
		//list.insertFirst( 8 );
		 
		list.deleteFirst();
		//list.insertFirst( 9 );
		list.insertLast( 3 );
		
		list.printLinkedList();
	}
}
