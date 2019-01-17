package algo.sorting;

/*
 * - We need to take each element from array and have to compare the same with all element till which is lowest.
 * - Replace the same with that found smallest element.
 * - Very simple technique, for each i consider it is small.
 * - Loop through j=i+1 and keep finding small and if found log that index
 * - After inner loop you will have small number and index
 * - Now we have to exchange this with outer loop, so first we took backup, then replace the current one and 
 * - later replace temp with index found in inner loop.
 * */

public class SelectionSort {

	public int[] sort( int array[] )
	{
		int small = 0;
		int big = 0;
		int bigIndex = 0;
		
		for( int i = 0; i < array.length; i++ )
		{
			small = array[i];
			int j = i+1;
			
			for( ; j < array.length; j++ )
			{
				if( small > array[j] )
				{
					small = array[j];
					bigIndex = j;
				}
			}
			
			int temp = array[i];
			array[i] = small;
			array[bigIndex] = temp;
		}
		
		for( int num: array ) System.out.print( num + " " );
		return array;
	}
	
	public static void main( String ...args )
	{
		SelectionSort obj = new SelectionSort();
		obj.sort( new int[] {31, 41, 59, 26, 41, 58}  );
	}
}
