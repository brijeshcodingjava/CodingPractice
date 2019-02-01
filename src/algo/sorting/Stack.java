package algo.sorting;

public class Stack<T> {

	private int maxLength;
	private int top;
	private Object[] stack;
	
	public Stack(int size)
	{
		this.maxLength = size;
		this.stack = new Object[ size ];
		top = -1;
	}
	
	public void push( T num )
	{
		if( isFull() ) {
			System.out.println("Error: Stack is Full! ");
			return;
		}
		
		top++;
		
		this.stack[ top ] = num;
	}
	
	public T pop()
	{
		if( isEmpty() )
		{
			System.out.println("Error: Stack is Empty !");
			return null;
		}
		
		int oldTop = top;
		top--;
		
		return (T) this.stack[ oldTop ];
	}
	
	public boolean isEmpty()
	{
		return ( top == -1 );
	}
	
	public boolean isFull()
	{
		return ( top == (this.maxLength-1) );
	}
	
	public static void main( String ...args )
	{
		Stack obj = new Stack(4);
		obj.push( "B" );
		obj.push( "R" );
		obj.push( "I" );
		obj.push( "J" );
		//obj.push( 8 );
		
		System.out.println( obj.pop() );
		System.out.println( obj.pop() );
		System.out.println( obj.pop() );
		System.out.println( obj.pop() );
	}
}
