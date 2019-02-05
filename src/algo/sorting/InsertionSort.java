package algo.sorting;

import java.util.Arrays;

/**
 * 
 * In this sorting algorithm, we are taking each element in sequence and comparing with prior elements.
 * Till we found the bigger element we keep swaping element with key (which is initial stored value) till we reach to index zero. 
 * 
 */
 
public class InsertionSort {

	public int[] doInsertionSort( int[] array )
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
		InsertionSort obj = new InsertionSort();
		//obj.doInsertionSortRecursion( new int[] {31, 41, 59, 26, 41, 58} ); //   5, 2, 4, 6, 1, 3
		int[] array = obj.doInsertionSort( new int[] {31, 41, 59, 26, 41, 58} ); //   5, 2, 4, 6, 1, 3
		
		Arrays.stream(array).forEach( num -> System.out.print( num + " " ));
	}
}
