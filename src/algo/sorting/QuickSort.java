package algo.sorting;

import java.util.Arrays;

/**
 * Same as Merge Sort where we used to perform divide and quncor. But in merge sort we need to create two,
 * additional arrays left and right and then merge. So sometimes we may have limited space, in that case Quick sort is a good choice.
 * 
 * Every time before we divide the array logically we try to find the pivot point.
 * That is taking the last element of array, and trying to just find the correct position of that element only.
 * 
 * Once we got correct position of last element we divide the array in two parts, before pivote point -1 and after +1.
 * 
 * To find the pivot point we have to compare each element of the array with key=last element. Untilate goal is to move
 * all element smaller than key to left side so that at the end of loop we can have correct position of key.
 * 
 * And for that we keep comparing every element with key and 1. will increment pivot index, 2. swap the value of pivot index.
 * 
 */

public class QuickSort {

	public int[] sort( int[] array )
	{
		return quickSort(array, 0, (array.length-1 ));
	}
	
	public int[] quickSort( int[] array, int start, int end )
	{
		if( start < end )
		{
			int pivotIndex = partition( array, start, end );
			
			quickSort( array, start, pivotIndex-1 );
			quickSort( array, pivotIndex+1, end );
		}
		
		return array;
	}
	
	public int partition( int[] array, int start, int end )
	{
		int pivotIndex = -1;
		int key = array[end];
		
		for( int j = 0; j <= end; j++ )
		{
			if( array[j] <= key )
			{
				pivotIndex++;
				
				int temp = array[j];
				
				array[j] = array[pivotIndex];
				array[pivotIndex] = temp;
			}
		}
		
		return pivotIndex;
	}
	
	public static void main( String ...args )
	{
		QuickSort obj = new QuickSort();
		//int array[] = obj.sort( new int[]{ 5, 2, 7, 4, 3, 1, 9, 2, 8 } ); //5, 7, 2, 9, 31, 41, 59, 26, 41, 58, 1, 3, 8, 4
		int array[] = obj.sort( new int[]{ 5, 7, 2, 9, 31, 41, 59, 26, 41, 58, 1, 3, 8, 4 } ); //
		
		System.out.println("Sorted Array =================");
		Arrays.stream( array ).forEach( num -> System.out.print( num + " " ) );
	}
}
