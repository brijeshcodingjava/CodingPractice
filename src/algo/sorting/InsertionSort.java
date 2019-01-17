package algo.sorting;

/**
 * 
 * In this sorting algorithm, we are taking each element in sequence and comparing with prior elements.
 * Till we found the bigger element we keep swaping element with key (which is initial stored value) till we reach to index zero. 
 * 
 */
 
public class InsertionSort {

	public int[] doInsertionSort( int[] array )
	{
		int[] result = null;
		int key = 0;
		int i = 0;
		
		for( int j = 1; j < array.length; j++ )
		{
			key = array[j];
			i = j - 1;
			
			while( i >= 0 && array[i] > key )
			{
				array[i+1] = array[i];
				i = i - 1;
			}
			
			array[ i + 1 ] = key;
		}
		
		for( int num : array ) System.out.print( num + " " );
		
		return array;
	}
	
	public int[] doInsertionSortRecursion( int[] array )
	{
		int key = 0;
		
		for( int j = 1; j < array.length; j++ )
		{
			key = array[j];
			
			sort( array, key, j-1 );
		}
		
		for( int num : array ) System.out.print( num + " " );
		return array;
	}
	
	public int[] sort( int[] array, int key, int start )
	{
		
		if( start >= 0 && array[start] > key )
		{
			array[start+1] = array[start];
			array[start] = key;
			
			start = start - 1;
			sort( array, key, start );
		}
		
		array[ start + 1 ] = key;
		
		return array;
	}
	
	public static void main( String ...args )
	{
		InsertionSort obj = new InsertionSort();
		obj.doInsertionSortRecursion( new int[] {31, 41, 59, 26, 41, 58} ); //   5, 2, 4, 6, 1, 3
		
	}
}
