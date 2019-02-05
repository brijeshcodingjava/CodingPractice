package algo.search;

/**
 * In Binary search we are not searching for an element from 0 to N.
 * Instead we will divide the array from middle and will see if the element we are looking
 * is exists in which range? For example if middle is Q and start is P and end is R,
 * then it will check values of element against value at middle like Q[i] and based on condition
 * it will choose the respective range like either from P to Q or may be Q+1 to R.
 * 
 * Keep repeating the step till we found value or -1 if not found.
 * 
 * So this way we can get lot of performance benefits against the linear search.
 * 
 **/
 
public class BinarySearch {

	public int search( int element, int[] array )
	{
		if( array == null ) return -1;
		if( array.length == 0 ) return -1;
		
		int start = 0;
		int end = array.length - 1;
		
		while( start <= end )
		{
			int middle = (start+end)/2;
			
			if( element == array[middle] ) 
				return middle;
			
			if( element < array[middle] ) 
				end = middle-1;
			else 
				start = middle + 1;
		}
		
		
		//return search( element, array, 0, array.length -1 );
		 return -1;
	}
	
	public int search( int element, int[] array, int start, int end )
	{
		int middle = (start + end)/2;
		
		if( element == array[middle] )
		{
			return middle;
		}
		
		if( element < array[middle] )
		{
			return search( element, array, 0, middle );
		}
		else
		{
			return search( element, array, middle+1, end );
		}
	}
	
	public static void main( String ...args )
	{
		BinarySearch obj = new BinarySearch();
		
		long index = obj.search( 3, new int[]{ 1,2,3,4,5,6,7,8,9 } );
		
		System.out.println( "Index >> " + index );
		
	}
}
