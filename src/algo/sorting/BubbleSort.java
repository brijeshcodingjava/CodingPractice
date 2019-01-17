package algo.sorting;

/*
 * 
 * Starting from the beginning of the list, compare every adjacent pair(2 elements side by side), swap their position if, 
 * they are not in the right order (the latter one is smaller than the former one). After each iteration, 
 * one less element (the last one) is needed to be compared until there are no more elements left to be compared.
 * 
 * Other words,
 * Compare first 2 element and swap if needed, then next 2 element till you reach the end. This way,
 * the one of big number will be bubbled/move to right most side and cycle will continue till length of array is just 1.
 * So all big numbers will be moved to right side, bubbled up and results into sorted array.
 * 
 * */
public class BubbleSort {

	public int[] sort( int[] array )
	{
		int length = array.length;
		
		while( length > 1 )
		{
			int i = 0;
			for( int j = 1; j < length; j++ )
			{
				int key = array[i];
				
				if( array[i] > array[j] )
				{
					int temp = array[j];
					array[i] = temp;
					array[j] = key;
				}
				i++;
			}
			length--;
		}
		
		for( int num: array ) System.out.print( num + " ");
		
		return array;
	}
	
	public static void main( String ...args )
	{
		BubbleSort obj = new BubbleSort();
		obj.sort( new int[] {31, 41, 59, 26, 41, 58}  );
	}
}
