import java.util.Arrays;

import org.omg.Messaging.SyncScopeHelper;

public class TestClass {

	
	public int[] mergeSort( int[] array )
	{
		divide( array, 0, array.length -1 );
		
		return array;
	}
	
	public int[] divide( int[] array, int start, int end )
	{
		int middle = 0;
		
		if( start < end )
		{
			middle = (start + end) / 2; 
			
			divide( array, start, middle );
			divide( array, middle+1, end );
			
			merge( array, start, middle, end );
		}
		
		return array;
	}
	
	public int[] merge( int[] array, int start, int middle, int end )
	{
		int[] left;
		int[] right;
		int leftLength = middle - start + 1;
		int rightLength = end - middle;
		
		leftLength = leftLength == 0 ? 1 : leftLength;
		rightLength = rightLength == 0 ? 1 : rightLength;
		
		System.out.println( "Start " + start + " middle " + middle + " end " + end + " rightlength " + rightLength + " leftlength " + leftLength );
		
		left = new int[ leftLength ];
		right = new int[ rightLength ];
		
		int index = 0;
		for( int i = start; i <= middle; i++ )
		{
			
			Arrays.stream(array).forEach( num -> System.out.print( num + " " ) );
			System.out.println( " i == " + i + " array value " + array[i]);
			
			left[index] = array[i];
			index++;
		}
		
		index = 0;
		for( int i = middle+1; i <= end; i++ )
		{
			right[index] = array[i];
			index++;
		}
		/*System.out.println( "Left>> " );
		Arrays.stream( left ).forEach( num -> System.out.print( num + " " ) );

		System.out.println( "Right>> " );
		Arrays.stream( right ).forEach( num -> System.out.print( num + " " ) );
*/
		int i = 0,j = 0;
		
		for( int k = start; k <= end; k++ )
		{
			if( i < left.length && j == right.length )
			{
				array[k] = left[i];
				i++;
			}
			
			else if( j < right.length  && i == left.length )
			{
				array[k] = right[j];
				j++;
			}
			
			else if( left[i] <= right[j] )
			{
				array[k] = left[i];
				i++;
			}
			else if( left[i] > right[j] )
			{
				array[k] = right[j];
				j++;
			}
		}
		
		return array;
	}
	
	public int[] selectionSort( int[] array )
	{
		for( int i = 0; i < array.length; i++ )
		{
			int original = array[i];
			int key = array[i];
			int selectedIndex = i;
			
			for( int j = i + 1; j < array.length; j++ )
			{
				if( key > array[j] )
				{
					selectedIndex = j;
					key = array[j];
				}
			}
			
			array[i] = array[selectedIndex];
			array[selectedIndex] = original;
		}
		
		return array;
	}
	
	public int[] insertionSort( int[] array )
	{
		for( int i = 1; i < array.length; i++ )
		{
			for( int j = i -1; j >= 0; j-- )
			{
				if( array[i] < array[j] )
				{
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
					i--;
				}
			}
		}
		return array;
	}
	
	public static void main( String ...args )
	{
		TestClass obj = new TestClass();
		//obj.doMergeSort( new int[] {5, 7, 2, 9, 1, 3, 8, 4} );
		//int array[] = obj.selectionSort( new int[] {5, 7, 2, 9, 1, 3, 8, 4} );
		//int array[] = obj.insertionSort( new int[] {5, 7, 2, 9, 31, 41, 59, 26, 41, 58, 1, 3, 8, 4} );
		int array[] = obj.mergeSort( new int[] {5, 7, 2, 9, 31, 41, 59, 26, 41, 58, 1, 3, 8, 4} );
		//int array[] = obj.mergeSort( new int[] {5, 7, 2, 9} );
		
		System.out.println( "Sorted Array >> " );
		Arrays.stream( array ).forEach( num -> System.out.print( num + " " ) );
	}
}
