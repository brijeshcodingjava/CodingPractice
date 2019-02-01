package algo.dstruct.common;

import java.util.Arrays;

/* 
 * FIRST COME -- FIRST SERVED
 * 
 *     front->  |  |  |  |  |  |  |  |  <-rear
 */


public class Queue {

	long array[]; // array which will hold queue elements
	int maxLength;    // Maximum length of queue
	int nItems;       // Total elements in queue
	int front;        // Front of the queue
	int rear;         // Rear of the queue
	
	public Queue( int size )
	{
		this.maxLength = size;
		this.array = new long[ size ];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}
	
	// We need to make sure we insert element from back/rear side. 
	// So we need to use rear pointer variable instead of front.
	public void insert( long item )
	{
		if( isFull() )
		{
			System.out.println("Error: Queue is full!");
			return;
		}
		this.rear++;
		this.array[ rear ] = item;
		this.nItems++;
	}
	
	// From queue element will always be removed from front, so we need to use front variable pointer for removal
	public long remove()
	{
		if( isEmpty() )
		{
			System.out.println("Error: Queue is empty!");
			return -1;
		}
		
		long removed = this.array[front];
		this.front++;
		this.nItems--;
		
		return removed;
	}
	
	public long peek()
	{
		return this.array[this.front];
	}
	
	public boolean isEmpty()
	{
		return (this.front == this.rear);
	}
	
	public boolean isFull()
	{
		return (this.rear == this.maxLength-1);
	}
	
	public void print()
	{
		System.out.print("[ ");
		Arrays.stream( this.array ).forEach(num -> System.out.print(num + " ") );
		System.out.print("]");
	}
	
	public int length()
	{
		return this.nItems;
	}
	
	public static void main( String ...args )
	{
		Queue obj = new Queue( 4 );
		obj.insert( 5 );
		obj.insert( 6 );
		obj.insert( 7 );
		obj.insert( 8 );
		obj.insert( 9 );
		
		obj.remove();
		obj.remove();
		
		System.out.println("Peak of Queue >> " + obj.peek() );
		System.out.println("Length of Queue >> " + obj.length() );
		
		obj.print();
		
	}
}
