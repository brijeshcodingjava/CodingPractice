package algo.sorting;

public class MergeSort {

	public int[] sort( int[] array, int start, int end )
	{
		int middle = 0;
		
		if( start < end )
		{
			middle = (start + end) / 2;
			
			sort( array, start, middle );
			sort( array, middle+1, end );
			
			merge( array, start, middle, end );
		}
		
		 
		
		return array;
	}
	
	public int[] merge( int array[], int start, int middle, int end )
	{
		int len1 = middle - start + 1;
		int len2 = end - middle ;
		
		if( end == 1 ) len1 = len2 = 1;
		
		int left[] = new int[ len1 ];
		int right[] = new int[ len2 ];
		
		int index = 0;
		for( int i = start; i <= middle ; i++ )
		{
			left[ index ] = array[i];
			index++;
		}
		index = 0;
		for( int i = middle+1; i <= end; i++ )
		{
			right[ index ] = array[i];
			index++;
		}
		
		int i = 0;
		int j = 0;
		for( int k = start; k <= end; k++ )
		{
			if( i == left.length && j < right.length ) 
			{
				array[k] = right[j];
				j++;
			}
			else if( j == right.length && i < left.length )
			{
				array[k] = left[i];
				i++;
			}
			
			else if( left[i] <= right[j] )
			{
				array[k] = left[i];
				i++;
			}
			else
			{
				array[k] = right[j];
				j++;
			}
		}
		
		
		
		return array;
	}
	
	public void doMergeSort( int[] array )
	{
		 sort( array, 0, array.length - 1 );
		for( int num : array ) System.out.print( num + " " );
	}
	
	public static void main( String ...args )
	{
		MergeSort obj = new MergeSort();
		//obj.doMergeSort(new int[] {5, 2, 4, 7, 1, 3, 9, 2, 6} );//( new int[]{5, 2, 4, 7, 1, 3, 9, 2, 6} );5, 7, 2, 9, 1, 3, 8, 4
		//obj.doMergeSort(new int[] {5, 2, 7, 4, 3, 1, 9, 2, 8} );
		obj.doMergeSort(new int[] { 9,8,7,6,5,1,2,3,4} );
	}
}
