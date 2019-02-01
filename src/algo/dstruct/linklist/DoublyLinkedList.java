package algo.dstruct.linklist;

public class DoublyLinkedList {

	Node first;
	Node last;
	
	public boolean isEmpty()
	{
		return first == null;
	}
	
	public void insertFirst( int data )
	{
		Node newNode = new Node( data );
		
		if( isEmpty() )
		{
			last = newNode; // If list is empty then last element will be your new element
		}
		else
		{
			first.previous = newNode; // If list is not empty then last element's/first element's previous will be new node.
			newNode.next = first; 
		}

		first = newNode;  // // Now make the new node as your first node.
	}
	
	public void insertLast( int data )
	{
		Node newNode = new Node( data );
		
		if( last != null )
		{
			newNode.previous = last;  // Add the reference of prevous to last node.
			last.next = newNode;      // Now add the new node at end
			
			last = newNode;           // Now last node is newly created node
		}
		else
		{
			insertFirst( data );
		}
	}
	
	public int deleteFirst()
	{
		// If there is no element.
		if( isEmpty() )
		{
			System.out.println("ERROR:: List is empty !");
			return -1;
		}
		
		// If there is only one element
		if( first == last )
		{
			first = last = null;
			return -1;
		}
		
		int removedData = first.data;    // First stored the node which is going to be delete so that we can retrive data when needed
		
		first = first.next;
		first.previous = null;   // Disconnect the previous reference
		
		return removedData;
	}
	
	public long deleteLast()
	{
		if( isEmpty() )
		{
			System.out.println("ERROR:: List is empty !");
			return -1;
		}
		
		long removedData = last.data;
		
		if( last == first )
		{
			return deleteFirst();
		}
		else
		{
			last = last.previous;  
			last.next = null;       // OR you can also do last.previous.next = null 
		}
		
		return removedData;
	}
	
	public boolean insertAfter( int data, int searchKey )
	{
		boolean result = false;
		
		if( isEmpty() )
		{
			insertFirst( data );
			return true;
		}
		
		// If only one element, insert last can be used.
		if( first == last )
		{
			insertLast( data );
			return true;
		}
		
		Node holder = new Node();
		holder.next = first;
		
		while( first != null )
		{
			if( first.data == searchKey )
			{
				Node currentChainNode = first.next;
				Node newNode = new Node( data );
				
				first.next = newNode;
				
				newNode.next = currentChainNode;
				currentChainNode.previous = newNode;
				
				newNode.previous = first;
				
				result = true;
				break;
			}
			first = first.next;
		}
		first = holder.next;
		
		return result;
	}
	
	public boolean deleteKey( int key )
	{
		boolean result = false;
		
		if( isEmpty() )
		{
			return false;
		}
		
		if( first == last )
		{
			deleteFirst();
			return true;
		}
		
		Node holder = new Node();
		holder.next = first;
		
		Node currentNode = holder.next;
		
		while( currentNode != null )
		{
			if( currentNode.data == key )
			{
				if( currentNode == last )
				{
					last = last.previous;
					last.next = null;
				}
				else
				{
					currentNode.previous.next = currentNode.next;
					currentNode.next.previous = currentNode.previous;
				}
				return true;
			}
			currentNode = currentNode.next;
		}
		return result;
	}
	
	public static void main( String ...args )
	{
		DoublyLinkedList obj = new DoublyLinkedList();
		
		obj.insertFirst( 5 );
		//obj.deleteFirst();
		//
		obj.insertLast( 8 );
		obj.insertFirst( 4 );
		
		obj.insertFirst( 2 );
		
		obj.printLinkedList();
		
		System.out.println("\nPrint Backward >>");
		//obj.printBackward();
		
		//obj.deleteFirst();
		
		obj.printLinkedList();
		
		obj.insertLast( 18 );
		
		obj.printLinkedList();
		
		//obj.deleteLast();
		
		obj.printLinkedList();
		
		System.out.println("\nPrint Backward >>");
		//obj.printBackward();
		
		obj.insertAfter( 100, 4 );
		
		obj.printLinkedList();
		
		obj.deleteKey( 5 );
		obj.printLinkedList();
		obj.printLinkedList();
		
		System.out.println("\nPrint Backward >>");
		obj.printBackward();
		
		obj.deleteKey( 18 );
		obj.printLinkedList();
		
		System.out.println("\nPrint Backward >>");
		obj.printBackward();
		
		obj.insertLast( 200 );
		obj.printLinkedList();
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
	
	public void printBackward()
	{
		Node holder = new Node();
		holder.next = last;
		//System.out.println("1 >> " + holder.next );
		
		System.out.println("[ ");
		while( last != null )
		{
			System.out.print( last.data + " ");
			last = last.previous;
		}
		System.out.println("]");
		
		this.last = holder.next;
		
		//System.out.println("2 >> " + this.last );
	}
}
